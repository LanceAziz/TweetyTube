package com.example.tweetytube.movie_list.presentation.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tweetytube.movie_list.data.repo.local.Movie
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

    // Display MoviesCollectionRow for each category in a LazyColumn
    LazyColumn {
       items(categoriesWithMovies) { item ->
            val (categoryTitle, movieList) = item
            MoviesCollectionRow(
                rowTitle = categoryTitle,
                movies = movieList
            )
        }
    }
}