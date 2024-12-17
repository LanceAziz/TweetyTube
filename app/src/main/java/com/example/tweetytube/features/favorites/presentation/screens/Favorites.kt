package com.example.tweetytube.features.favorites.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.tweetytube.R
import com.example.tweetytube.core.utils.Screen
import com.example.tweetytube.features.favorites.presentation.viewModel.FavoritesViewModel
import com.example.tweetytube.features.movieList.presentation.components.MovieMiniCard.MovieMiniCard
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel
import com.example.tweetytube.ui.theme.bgLight
import com.example.tweetytube.ui.theme.errorLight
import com.example.tweetytube.ui.theme.secondaryLight

@Composable
fun Favorites(
    navController: MovieListViewModel,
    favoritesViewModel: FavoritesViewModel,
    userToken: String?,
    goToDetails: (Int) -> Unit
) {

    val favoritesState = favoritesViewModel.favoritesState.collectAsStateWithLifecycle()
    val movieList = favoritesState.value.data ?: emptyList()


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(movieList) { movie ->
            val context = LocalContext.current
            val dismissState = rememberSwipeToDismissBoxState(
                confirmValueChange = {
                    if (it == SwipeToDismissBoxValue.EndToStart) {
                        favoritesViewModel.removeFavorite(userToken, movie.id)
                        favoritesViewModel.getFavorites(userToken)
                        Toast.makeText(context, "${movie.title} removed!!", Toast.LENGTH_SHORT)
                            .show()
                        true
                    } else {
                        false
                    }
                }
            )

            SwipeToDismissBox(
                state = dismissState,
                backgroundContent = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(secondaryLight)
                            .padding(horizontal = 30.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(36.dp)
                                .align(Alignment.CenterEnd),
                            painter = painterResource(id = R.drawable.heart_crack_solid),
                            contentDescription = "Search",
                            tint = bgLight
                        )
                    }
                }
            ) {
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .clip(RoundedCornerShape(18.dp))
                ) {
                    MovieMiniCard(movieSearch = movie, goToDetails = goToDetails)
                }

            }

        }
    }


//    LazyColumn {
//        items(1) {
//            movieList.map { movie ->
//                MovieMiniCard(movieSearch = movie, goToDetails = goToDetails)
//            }
//        }
//    }
}

