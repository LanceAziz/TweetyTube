package com.example.tweetytube.movie_list.utils

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object HomeScreen: Screen()

    @Serializable
    data object FavoriteScreen: Screen()

    @Serializable
    data object ProfileScreen: Screen()
}