package com.example.tweetytube.features.movieList.presentation.viewModel

import com.example.tweetytube.movie_list.data.repo.local.Movie
import com.example.tweetytube.core.utils.Category

data class MovieListState(
    val isLoading: Boolean = false,
    val currentCategory: String = Category.POPULAR,

    val popularMovieListPage: Int = 1,
    val upcomingMovieListPage: Int = 1,
    val topRatedMovieListPage: Int = 1,

    val popularMovieList: List<Movie> = emptyList(),
    val upcomingMovieList: List<Movie> = emptyList(),
    val topRatedMovieList: List<Movie> = emptyList()
)