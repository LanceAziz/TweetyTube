package com.example.tweetytube.movie_list.presentation.screens

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object HomeScreen: Screen()

    @Serializable
    data object FavoriteScreen: Screen()

    @Serializable
    data object ProfileScreen: Screen()
}