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
import androidx.navigation.toRoute
import com.example.tweetytube.core.utils.Screen.*
import com.example.tweetytube.features.auth.presentation.screens.Login
import com.example.tweetytube.features.auth.presentation.screens.SignUp
import com.example.tweetytube.features.auth.presentation.viewModel.AuthViewModel
import com.example.tweetytube.features.details.presentation.screens.Details
import com.example.tweetytube.features.details.presentation.viewModel.DetailsViewModel
import com.example.tweetytube.features.favorites.presentation.screens.Favorites
import com.example.tweetytube.features.movieList.presentation.screens.Home
import com.example.tweetytube.features.movieList.presentation.screens.Search
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel
import com.example.tweetytube.features.profile.presentation.screens.Profile

data class AnimationTransitions(
    val enterTransition: () -> EnterTransition,
    val exitTransition: () -> ExitTransition,
)

@Composable
fun NavigationComponent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    sharedViewModel: MovieListViewModel,
    detailsViewModel: DetailsViewModel,
    authViewModel: AuthViewModel
) {
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
        startDestination = LoginScreen
    ) {
        composable<HomeScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            Home(movieListViewModel = sharedViewModel,
                goToDetails = { id ->
                    navController.navigate(DetailsScreen(id))
                }
            )

        }
        composable<FavoriteScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            Favorites(navController = sharedViewModel, goToDetails = { id ->
                navController.navigate(DetailsScreen(id))
            })
        }
        composable<ProfileScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            Profile()
        }
        composable<LoginScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            Login(navController = navController, authViewModel = authViewModel)
        }
        composable<SignUpScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            SignUp(navController = navController, authViewModel = authViewModel)
        }
        composable<SearchScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        ) {
            Search(movieListViewModel = sharedViewModel,
                goToDetails = { id ->
                    navController.navigate(DetailsScreen(id))
                }
            )
        }
        composable<DetailsScreen>(
            enterTransition = { animations.enterTransition() },
            exitTransition = { animations.exitTransition() },
            popEnterTransition = { animations.enterTransition() },
            popExitTransition = { animations.exitTransition() }
        )
        {
            val details = requireNotNull(it.toRoute<DetailsScreen>())
            Details(id = details.id, detailsViewModel = detailsViewModel)
        }
    }
}