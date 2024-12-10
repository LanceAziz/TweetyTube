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
import com.example.tweetytube.features.movieList.presentation.components.moviesCollectionRow.MoviesCollectionRow
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel

@Composable
fun Home() {
    val movieListViewModel = hiltViewModel<MovieListViewModel>()
    val movieListState = movieListViewModel.movieListState.collectAsState().value

    val categoriesWithMovies = listOf(
        Triple("Trending Now", movieListState.popularMovieList, movieListState.isLoadingPopular),
        Triple("Upcoming Movies", movieListState.upcomingMovieList, movieListState.isLoadingUpcoming),
        Triple("Top Rated Movies", movieListState.topRatedMovieList, movieListState.isLoadingTopRated)
    )

    LazyColumn {
        itemsIndexed(categoriesWithMovies) { index, item ->
            val (categoryTitle, movieList, loading) = item
            if (index == 0) {
                Spacer(modifier = Modifier.height(16.dp))
            }
            MoviesCollectionRow(
                rowTitle = categoryTitle,
                movies = movieList,
                loading = loading
            )
        }
    }
}