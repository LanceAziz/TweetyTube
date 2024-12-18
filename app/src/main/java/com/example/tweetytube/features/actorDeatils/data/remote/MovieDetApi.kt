package com.example.tweetytube.features.actorDeatils.data.remote

import com.example.tweetytube.core.utils.Urls.Companion.MOVIES_API_KEY
import com.example.tweetytube.features.actorDeatils.data.remote.response.MovieDetDto
import com.example.tweetytube.features.actorDeatils.data.remote.response.MovieDetListDto
import com.example.tweetytube.features.details.data.remote.response.CreditsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetApi {
    @GET("person/{person_id}/movie_credits")
    suspend fun getMovieDet(
        @Path("person_id") creditId: Int,
        @Query("api_key") apiKey: String = MOVIES_API_KEY
    ): MovieDetListDto
}