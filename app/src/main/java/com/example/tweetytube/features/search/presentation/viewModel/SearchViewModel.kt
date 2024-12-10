package com.example.tweetytube.features.search.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SearchViewModel() : ViewModel() {
    private var _searchState by mutableStateOf(SearchState())

    val getSearchText: String get() = _searchState.searchText

    fun updateSearchText(newSearchText: String) {
        _searchState = _searchState.copy(searchText = newSearchText)
        Log.d("SearchViewModel", "updateSearchText: $newSearchText")
    }
}