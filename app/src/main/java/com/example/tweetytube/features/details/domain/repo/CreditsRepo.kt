package com.example.tweetytube.features.details.domain.repo

import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.details.domain.model.Credits
import kotlinx.coroutines.flow.Flow

interface CreditsRepo {
    suspend fun getCredits(
        movieId: Int,
    ): Flow<Resource<List<Credits>>>
}