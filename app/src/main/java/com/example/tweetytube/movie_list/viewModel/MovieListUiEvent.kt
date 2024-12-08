package com.example.tweetytube.movie_list.viewModel

sealed interface MovieListUiEvent {
    data class Paginate(val category: String) : MovieListUiEvent
}