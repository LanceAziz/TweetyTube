package com.example.tweetytube.features.movieList.presentation.viewModel

import com.example.tweetytube.core.utils.Category
import com.example.tweetytube.movie_list.data.repo.local.Movie

data class SearchState(
    val searchText: String = "",
    val filter: String = Category.POPULAR,
    val searchResult: List<Movie> = emptyList<Movie>()
)