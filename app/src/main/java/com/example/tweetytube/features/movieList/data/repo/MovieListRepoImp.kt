package com.example.tweetytube.features.movieList.data.repo

import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.movieList.data.mappers.toMovie
import com.example.tweetytube.features.movieList.data.mappers.toMovieEntity
import com.example.tweetytube.features.movieList.data.remote.MoviesApi
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo
import com.example.tweetytube.movie_list.data.repo.local.Movie
import com.example.tweetytube.movie_list.data.repo.local.MovieDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieListRepoImp @Inject constructor(
    private val movieApi: MoviesApi,
    private val movieDatabase: MovieDatabase,
) : MovieListRepo {
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int,
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))
            val localMovieList = movieDatabase.movieDao.getMoviesByCategory(category)
            val shouldLoadLocalMovies = localMovieList.isNotEmpty() && !forceFetchFromRemote

            if (shouldLoadLocalMovies) {
                emit(Resource.Success(data = localMovieList.map { movieEntity ->
                    movieEntity.toMovie(category)
                }))
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteMovieList = try {
                movieApi.getMovies(category, page)
            } catch (e: Exception) {
                emit(Resource.Error("Error loading Movies"))
                return@flow
            }

            val movieEntities =
                remoteMovieList.results.let {
                    it.map { movieDto ->
                        movieDto.toMovieEntity(category)
                    }
                }

            movieDatabase.movieDao.upsertMovieList(movieEntities)

            emit(Resource.Success(data = movieEntities.map { movieEntity ->
                movieEntity.toMovie(
                    category
                )
            }))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(true))
            val movieEntity = movieDatabase.movieDao.getMovieById(id)
            if (movieEntity != null) {
                // Safely emit the movie if it exists
                emit(
                    Resource.Success(movieEntity.toMovie(movieEntity.category))
                )
            } else {
                // Handle the case where movieEntity is null (no movie found)
                emit(Resource.Error("Error: Movie not found"))
            }
            emit(Resource.Error("Error no such movie"))
            emit(Resource.Loading(false))
        }
    }
}