package com.example.tweetytube.core.utils

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    object HomeScreen : Screen()

    @Serializable
    data class DetailsScreen(val id: Int) : Screen()

    @Serializable
    object FavoriteScreen : Screen()

    @Serializable
    object ProfileScreen : Screen()

    @Serializable
    data class SearchScreen(val id: Int?) : Screen()

    @Serializable
    object LoginScreen : Screen()

    @Serializable
    object SignUpScreen : Screen()

}