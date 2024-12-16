package com.example.tweetytube.features.supplementary.topBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tweetytube.R
import com.example.tweetytube.core.utils.Category
import com.example.tweetytube.core.utils.Screen
import com.example.tweetytube.features.movieList.presentation.components.searchFilter.FilterChip
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel
import com.example.tweetytube.ui.theme.*

@Composable
fun TopBar(
    navController: NavHostController,
    movieListViewModel: MovieListViewModel = hiltViewModel()
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = navBackStackEntry?.destination

    val searchState = movieListViewModel.searchState.collectAsStateWithLifecycle()
    val categoriesWithMovies = listOf(
        Triple("Trending", R.drawable.fire_solid, Category.POPULAR),
        Triple("Upcoming", R.drawable.ticket_solid, Category.UPCOMING),
        Triple("Top Rated", R.drawable.star_solid, Category.TOP_RATED),
    )
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 8.dp, end = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_minimal),
                contentDescription = "Tweety Tube Logo",
                modifier = Modifier
                    .size(70.dp)
                    .clickable(onClick = {
                        navController.navigate(Screen.HomeScreen)
                    },
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() })
            )
            if (currentDestination?.route?.contains(
                    Screen.SearchScreen::class.simpleName ?: ""
                ) == true
            ) {
                OutlinedTextField(
                    value = searchState.value.searchText,
                    onValueChange = {
                        movieListViewModel.setSearchText(it)
                        movieListViewModel.reboundedSearch(it, movieListViewModel.filter)

                    },
                    placeholder = { Text("Search...") },
                    singleLine = true,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = primaryLight,
                        unfocusedBorderColor = outlineLight,
                        cursorColor = secondaryLight,
                    ),
                    shape = RoundedCornerShape(32.dp)
                )
            } else {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.align(Alignment.CenterStart)) {
                        Text(
                            "Tweety",
                            fontSize = 26.sp,
                            color = primaryLight,
                            fontWeight = FontWeight.Bold
                        )
                        Text("Tube", fontSize = 26.sp, color = MaterialTheme.colorScheme.outline)
                    }
                    Icon(
                        modifier = Modifier
                            .size(26.dp)
                            .clickable(onClick = {
                                movieListViewModel.setSearchText("")
                                navController.navigate(Screen.SearchScreen(null))
                            },
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() })
                            .align(Alignment.CenterEnd),
                        painter = painterResource(id = R.drawable.search_solid),
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
        if (currentDestination?.route?.contains(
                Screen.SearchScreen::class.simpleName ?: ""
            ) == true
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                categoriesWithMovies.map { item ->
                    val (categoryTitle, icon, category) = item
                    FilterChip(
                        text = categoryTitle,
                        icon = icon,
                        isSelected = movieListViewModel.filter == category,
                        onClick = {
                            movieListViewModel.setFilter(category)
                            movieListViewModel.movieQuery(
                                movieListViewModel.searchText,
                                movieListViewModel.filter
                            )
                        })
                }
            }
        }
    }
}