package com.example.tweetytube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tweetytube.movie_list.presentation.components.bottom_navbar.BottomNavbar
import com.example.tweetytube.movie_list.presentation.components.top_bar.TopBar
import com.example.tweetytube.movie_list.presentation.screens.favorites.Favorites
import com.example.tweetytube.movie_list.presentation.screens.home.Home
import com.example.tweetytube.movie_list.presentation.screens.profile.Profile
import com.example.tweetytube.movie_list.presentation.screens.search.Search
import com.example.tweetytube.movie_list.utils.Screen.*
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
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = { BottomNavbar(navController = navController) },
                    contentWindowInsets = WindowInsets(0.dp),
                ) { innerPadding ->
                    NavigationComponent(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationComponent(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(36.dp)),
        navController = navController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen>() {
            Home(navController)
        }
        composable<FavoriteScreen>() {
            Favorites()
        }
        composable<ProfileScreen>() {
            Profile()
        }
        composable<SearchScreen>() {
            Search()
        }
    }
}