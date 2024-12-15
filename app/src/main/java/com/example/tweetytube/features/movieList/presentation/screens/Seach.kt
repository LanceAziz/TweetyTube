package com.example.tweetytube.features.movieList.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.tweetytube.R
import com.example.tweetytube.features.movieList.presentation.components.MovieMiniCard.MovieMiniCard
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel

@Composable
fun Search(movieListViewModel: MovieListViewModel = hiltViewModel(),
           goToDetails: (Int) -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()
    val searchState = movieListViewModel.searchState.collectAsStateWithLifecycle()

    if (searchState.value.searchText.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.tweety_search),
                contentDescription = "Tweety Search",
                modifier = Modifier.size(220.dp)
            )
            Text(text = "How May I help you?")
        }
    } else if (searchState.value.searchResult.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = if (isDarkTheme) {
                        painterResource(id = R.drawable.tweety_error_dark)
                    } else {
                        painterResource(id = R.drawable.tweety_error_light)
                    },
                    contentDescription = "Tweety Error",
                    modifier = Modifier.size(220.dp)
                )
                Text(text = "No Results Found")
            }
        } else {
            LazyColumn {
                item {
                    searchState.value.searchResult.map { movie ->
                        MovieMiniCard(movieSearch = movie,
                            goToDetails = goToDetails)
                    }
                }
            }
        }
}

