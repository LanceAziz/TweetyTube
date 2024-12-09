package com.example.tweetytube.movie_list.data.repo.remote

import com.example.tweetytube.BuildConfig
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

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w342"
        const val MOVIES_API_KEY = BuildConfig.MOVIES_API_KEY
    }

}