package com.example.tweetytube.features.movieList.data.remote

import com.example.tweetytube.core.utils.Urls.Companion.MOVIES_API_KEY
import com.example.tweetytube.movie_list.data.repo.remote.response.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/{category}")
    suspend fun getMovies(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = MOVIES_API_KEY
    ): MovieListDto
}