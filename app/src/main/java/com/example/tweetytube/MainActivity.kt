package com.example.tweetytube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.tweetytube.core.navigation.NavigationComponent
import com.example.tweetytube.features.details.presentation.viewModel.DetailsViewModel
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel
import com.example.tweetytube.features.supplementary.bottomBar.BottomNavbar
import com.example.tweetytube.features.supplementary.topBar.TopBar
import com.example.tweetytube.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val sharedMovieListViewModel = hiltViewModel<MovieListViewModel>()
                val detailsViewModel = hiltViewModel<DetailsViewModel>()
                Scaffold(
                    topBar = {
                        TopBar(
                            navController = navController,
                            movieListViewModel = sharedMovieListViewModel
                        )
                    },
                    bottomBar = { BottomNavbar(navController = navController) },
                    contentWindowInsets = WindowInsets(0.dp),
                ) { innerPadding ->
                    NavigationComponent(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        sharedViewModel = sharedMovieListViewModel,
                        detailsViewModel = detailsViewModel
                    )
                }
            }
        }
    }
}