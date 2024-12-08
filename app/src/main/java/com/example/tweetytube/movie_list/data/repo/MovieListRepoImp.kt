package com.example.tweetytube.movie_list.data.repo

import com.example.tweetytube.movie_list.data.repo.local.Movie
import com.example.tweetytube.movie_list.data.repo.local.MovieDatabase
import com.example.tweetytube.movie_list.data.repo.remote.MoviesApi
import com.example.tweetytube.movie_list.data.mappers.toMovie
import com.example.tweetytube.movie_list.data.mappers.toMovieEntity
import com.example.tweetytube.movie_list.domain.repo.MovieListRepo
import com.example.tweetytube.movie_list.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieListRepoImp @Inject constructor(
    private val movieApi: MoviesApi,
    private val movieDatabase: MovieDatabase
) : MovieListRepo {
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
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
                emit(
                    Resource.Success(movieEntity.toMovie(movieEntity.category))
                )
                emit(Resource.Loading(false))
                return@flow
            }
            emit(Resource.Error("Error no such movie"))
            emit(Resource.Loading(false))
        }
    }
}