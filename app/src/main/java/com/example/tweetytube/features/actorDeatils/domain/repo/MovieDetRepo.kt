package com.example.tweetytube.features.actorDeatils.domain.repo

import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.actorDeatils.domain.model.MovieDet
import com.example.tweetytube.features.details.domain.model.Credits
import kotlinx.coroutines.flow.Flow

interface MovieDetRepo {
    suspend fun getMovieDet(
        creditId: Int,
    ): Flow<Resource<List<MovieDet>>>
}