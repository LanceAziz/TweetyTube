package com.example.tweetytube.features.actorDeatils.data.repo

import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.actorDeatils.data.local.MovieDetDatabase
import com.example.tweetytube.features.actorDeatils.data.mappers.toMovieDet
import com.example.tweetytube.features.actorDeatils.data.mappers.toMovieDetEntity
import com.example.tweetytube.features.actorDeatils.data.remote.MovieDetApi
import com.example.tweetytube.features.actorDeatils.domain.model.MovieDet
import com.example.tweetytube.features.actorDeatils.domain.repo.MovieDetRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetRepoImp @Inject constructor(
    private val movieDetApi: MovieDetApi,
    private val movieDetDatabase: MovieDetDatabase
) : MovieDetRepo {
    override suspend fun getMovieDet(
        creditId: Int
    ): Flow<Resource<List<MovieDet>>> {
        return flow {
            emit(Resource.Loading(true))
            val localMovieDetList = movieDetDatabase.movieDetDao.getMovieByCreditId(creditId)
            val shouldLoadLocalMovieDet = localMovieDetList.isNotEmpty()

            if (shouldLoadLocalMovieDet) {
                emit(Resource.Success(data = localMovieDetList.map { movieDetEntity ->
                    movieDetEntity.toMovieDet()
                }))
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteMovieDetList = try {
                movieDetApi.getMovieDet(creditId)
            } catch (e: Exception) {
                emit(Resource.Error("Error loading Cast"))
                return@flow
            }


            val movieDetEntities = remoteMovieDetList.movieDetDto.map { movieDetDto ->
                movieDetDto.toMovieDetEntity()
            }

            movieDetDatabase.movieDetDao.upsertCreditList(movieDetEntities)

            emit(Resource.Success(data = movieDetEntities.map { creditEntity ->
                creditEntity.toMovieDet()
            }))
            emit(Resource.Loading(false))
        }
    }
}