package com.example.tweetytube.core.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tweetytube.core.utils.Screen.FavoriteScreen
import com.example.tweetytube.core.utils.Screen.HomeScreen
import com.example.tweetytube.core.utils.Screen.ProfileScreen
import com.example.tweetytube.core.utils.Screen.SearchScreen
import com.example.tweetytube.features.favorites.presentation.screens.Favorites
import com.example.tweetytube.features.movieList.presentation.screens.Home
import com.example.tweetytube.features.profile.presentation.screens.Profile
import com.example.tweetytube.features.movieList.presentation.screens.Search

data class AnimationTransitions(
    val enterTransition: () -> EnterTransition,
    val exitTransition: () -> ExitTransition,
)

@Composable
fun NavigationComponent(modifier: Modifier = Modifier, navController: NavHostController) {
    val animations = AnimationTransitions(
        enterTransition = {
            slideInHorizontally(initialOffsetX = { fullWidth -> -fullWidth }) + fadeIn()
        },

        exitTransition = {
            slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth }) + fadeOut()
        }
    )
    NavHost(
        modifier = modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(36.dp)),
        navController = navController,
        startDestination = SearchScreen
    ) {
        composable<HomeScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            Home()
        }
        composable<FavoriteScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            Favorites()
        }
        composable<ProfileScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            Profile()
        }
        composable<SearchScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            Search()
        }
    }
}