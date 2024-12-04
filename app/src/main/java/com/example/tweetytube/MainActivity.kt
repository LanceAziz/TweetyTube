package com.example.tweetytube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tweetytube.presentation.components.BottomNavbar
import com.example.tweetytube.presentation.screens.Screen.*
import com.example.tweetytube.presentation.screens.favorites.Favorites
import com.example.tweetytube.presentation.screens.home.Home
import com.example.tweetytube.presentation.screens.profile.Profile
import com.example.tweetytube.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavbar(navController)
                    }) { innerPadding ->
                    NavigationComponent(innerPadding = innerPadding, navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationComponent(innerPadding: PaddingValues, navController: NavController) {
    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen>() {
            Home()
        }
        composable<FavoriteScreen>() {
            Favorites()
        }
        composable<ProfileScreen>() {
            Profile()
        }
    }
}