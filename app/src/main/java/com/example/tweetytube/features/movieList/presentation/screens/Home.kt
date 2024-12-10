package com.example.tweetytube.features.movieList.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tweetytube.features.movieList.presentation.components.movies_collection_row.MoviesCollectionRow
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel

@Composable
fun Home() {
    val movieListViewModel = hiltViewModel<MovieListViewModel>()
    val movieListState = movieListViewModel.movieListState.collectAsState().value

    val categoriesWithMovies = listOf(
        "Trending Now" to movieListState.popularMovieList,
        "Upcoming Movies" to movieListState.upcomingMovieList,
        "Top Rated Movies" to movieListState.topRatedMovieList
    )
    LazyColumn {
        itemsIndexed(categoriesWithMovies) { index, item ->
            val (categoryTitle, movieList) = item
            if (index == 0) {
                Spacer(modifier = Modifier.height(16.dp))
            }
            MoviesCollectionRow(
                rowTitle = categoryTitle,
                movies = movieList
            )
        }
    }
}