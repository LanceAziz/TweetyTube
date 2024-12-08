package com.example.tweetytube.movie_list.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tweetytube.movie_list.presentation.components.movies_collection_row.MoviesCollectionRow
import com.example.tweetytube.movie_list.viewModel.MovieListViewModel

@Composable
fun Home(navController: NavHostController) {
//    val movieListViewModel = hiltViewModel<MovieListViewModel>()
//    val movieState = movieListViewModel.movieListState.collectAsState().value
//
//    // List of categories and their corresponding movie lists
//    val categoriesWithMovies = listOf(
//        "Trending Now" to movieState.popularMovieList,
//        "Upcoming Movies" to movieState.upcomingMovieList,
//        "Top Rated Movies" to movieState.topRatedMovieList
//    )
//
//    // Display MoviesCollectionRow for each category
//    categoriesWithMovies.forEach { (categoryTitle, movieList) ->
//        MoviesCollectionRow(
//            categoryTitle,
//            movieList
//        )
//    }
}