package com.example.tweetytube.movie_list.presentation.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tweetytube.movie_list.presentation.components.movies_collection_row.MoviesCollectionRow
import com.example.tweetytube.movie_list.viewModel.MovieListViewModel

@Composable
fun Home(navController: NavHostController) {
    val movieListViewModel = hiltViewModel<MovieListViewModel>()
    val movieState = movieListViewModel.movieListState.collectAsState().value

    val categoriesWithMovies = listOf(
        "Trending Now" to movieState.popularMovieList,
        "Upcoming Movies" to movieState.upcomingMovieList,
        "Top Rated Movies" to movieState.topRatedMovieList
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