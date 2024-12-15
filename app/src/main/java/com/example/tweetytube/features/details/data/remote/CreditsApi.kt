package com.example.tweetytube.features.details.data.remote

import com.example.tweetytube.core.utils.Urls.Companion.MOVIES_API_KEY
import com.example.tweetytube.features.details.data.remote.response.CreditsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CreditsApi {
    @GET("movie/{movieId}/credits")
    suspend fun getCredits(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String = MOVIES_API_KEY
    ): CreditsDto
}