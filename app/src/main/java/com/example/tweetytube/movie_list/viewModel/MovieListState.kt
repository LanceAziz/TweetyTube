package com.example.tweetytube.movie_list.viewModel

import com.example.tweetytube.movie_list.data.repo.local.Movie
import com.example.tweetytube.movie_list.utils.Category

data class MovieListState(
    val isLoadingPopular: Boolean = false,
    val isLoadingUpcoming: Boolean = false,
    val isLoadingTopRated: Boolean = false,
    val currentCategory: String = Category.POPULAR,

    val popularMovieListPage: Int = 1,
    val upcomingMovieListPage: Int = 1,
    val topRatedMovieListPage: Int = 1,

    val popularMovieList: List<Movie> = emptyList(),
    val upcomingMovieList: List<Movie> = emptyList(),
    val topRatedMovieList: List<Movie> = emptyList()
)