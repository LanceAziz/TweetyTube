package com.example.tweetytube.features.details.data.repo

import android.util.Log
import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.details.data.local.CreditsDatabase
import com.example.tweetytube.features.details.data.mappers.toCredits
import com.example.tweetytube.features.details.data.mappers.toCreditsEntity
import com.example.tweetytube.features.details.data.remote.CreditsApi
import com.example.tweetytube.features.details.domain.model.Credits
import com.example.tweetytube.features.details.domain.repo.CreditsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreditsRepoImp @Inject constructor(
    private val creditsApi: CreditsApi,
    private val creditsDatabase: CreditsDatabase
) : CreditsRepo {
    override suspend fun getCredits(
        movieId: Int
    ): Flow<Resource<List<Credits>>> {
        return flow {
            emit(Resource.Loading(true))
            val localCreditsList = creditsDatabase.creditsDao.getCastByMovieId(movieId)
            val shouldLoadLocalCredits = localCreditsList.isNotEmpty()

            if (shouldLoadLocalCredits) {
                emit(Resource.Success(data = localCreditsList.map { creditEntity ->
                    creditEntity.toCredits()
                }))
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteCreditsList = try {
                creditsApi.getCredits(movieId)
            } catch (e: Exception) {
                emit(Resource.Error("Error loading Cast"))
                return@flow
            }


            val creditEntities = remoteCreditsList.castDto.map { creditsDto ->
                creditsDto.toCreditsEntity()
            }

            creditsDatabase.creditsDao.upsertMovieList(creditEntities)

            emit(Resource.Success(data = creditEntities.map { creditEntity ->
                creditEntity.toCredits()
            }))
            emit(Resource.Loading(false))
        }
    }
}