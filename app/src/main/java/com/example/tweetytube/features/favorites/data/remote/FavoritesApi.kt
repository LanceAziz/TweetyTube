package com.example.tweetytube.features.favorites.data.remote

import com.example.tweetytube.features.favorites.data.remote.request.ToggleFavoritesRequest
import com.example.tweetytube.features.favorites.data.remote.response.FavoriteResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface FavoritesApi {
    @POST("tmdb/addFavourite/v1")
    suspend fun addFavorite(
        @Header("Authorization") token: String?,
        @Body request: ToggleFavoritesRequest
    )

    @DELETE("tmdb/removeFavourite/v1")
    suspend fun removeFavorite(
        @Header("Authorization") token: String?,
        @Body request: ToggleFavoritesRequest
    )

    @GET("tmdb/getFavourites/v1")
    suspend fun getFavorites(
        @Header("Authorization") token: String?
    ): FavoriteResponse

}