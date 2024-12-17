package com.example.tweetytube.features.favorites.domain.repo

import com.example.tweetytube.movie_list.data.repo.local.Movie

interface FavoritesRepo {
    suspend fun addFavorite(token: String?, movieId: Int)
    suspend fun removeFavorite(token: String?, movieId: Int)
    suspend fun getFavorites(token: String?): List<Movie>
}