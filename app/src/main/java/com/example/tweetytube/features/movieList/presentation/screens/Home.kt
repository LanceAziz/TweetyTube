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
import com.example.tweetytube.features.favorites.presentation.viewModel.FavoritesViewModel
import com.example.tweetytube.features.movieList.presentation.components.moviesCollectionRow.MoviesCollectionRow
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel
import com.example.tweetytube.features.supplementary.loading.LoadingAnimation

@Composable
fun Home(
    movieListViewModel: MovieListViewModel = hiltViewModel(),
    favoritesViewModel: FavoritesViewModel,
    userToken: String?,
    goToDetails: (Int) -> Unit
) {
    val movieListState = movieListViewModel.movieListState.collectAsState().value

    val categoriesWithMovies = listOf(
        "Trending Now" to movieListState.popularMovieList,
        "Upcoming Movies" to movieListState.upcomingMovieList,
        "Top Rated Movies" to movieListState.topRatedMovieList
    )
    if (movieListState.isLoadingPopular || movieListState.isLoadingUpcoming || movieListState.isLoadingTopRated) {
        LoadingAnimation()
    } else {
        LazyColumn {
            itemsIndexed(categoriesWithMovies) { index, item ->
                val (categoryTitle, movieList) = item
                if (index == 0) {
                    Spacer(modifier = Modifier.height(16.dp))
                }
                MoviesCollectionRow(
                    rowTitle = categoryTitle,
                    movies = movieList,
                    favoritesViewModel = favoritesViewModel,
                    userToken = userToken,
                    goToDetails = goToDetails
                )
            }
        }
    }
}