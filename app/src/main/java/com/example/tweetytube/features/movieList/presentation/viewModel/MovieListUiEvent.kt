package com.example.tweetytube.features.movieList.presentation.viewModel

sealed interface MovieListUiEvent {
    data class Paginate(val category: String) : MovieListUiEvent
}