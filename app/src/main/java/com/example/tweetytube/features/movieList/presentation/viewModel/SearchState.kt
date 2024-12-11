package com.example.tweetytube.features.movieList.presentation.viewModel

import com.example.tweetytube.core.utils.Category

data class SearchState(
    val searchText: String = "",
    val filter: String = Category.POPULAR
)