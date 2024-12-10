package com.example.tweetytube.features.search.presentation.viewModel

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SearchState(
    val isSearchOn: Boolean = false,
    val searchText: String = "",
    val animatedWidth: Dp = 0.dp
)