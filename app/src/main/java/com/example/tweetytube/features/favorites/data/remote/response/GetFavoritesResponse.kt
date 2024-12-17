package com.example.tweetytube.features.favorites.data.remote.response

import com.example.tweetytube.movie_list.data.repo.local.Movie

data class FavoriteResponse(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
)