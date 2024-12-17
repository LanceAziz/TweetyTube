package com.example.tweetytube.features.favorites.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.tweetytube.features.movieList.presentation.components.MovieMiniCard.MovieMiniCard
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel

@Composable
fun Favorites(navController: MovieListViewModel, goToDetails: (Int) -> Unit) {
    val movieList =
        navController.movieListState.collectAsStateWithLifecycle().value.popularMovieList

    LazyColumn {
        items(1) {
            movieList.map { movie ->
                MovieMiniCard(movieSearch = movie, goToDetails = goToDetails)
            }
        }
    }
}