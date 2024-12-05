package com.example.tweetytube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tweetytube.presentation.components.bottom_navbar.BottomNavbar
import com.example.tweetytube.presentation.components.top_bar.TopBar
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
                    topBar = { TopBar() },
                    contentWindowInsets = WindowInsets(0.dp),
                ) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        Column(
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp, bottom = 110.dp, top = 16.dp)
                        ) {
                            NavigationComponent(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }
                        BottomNavbar(
                            navController = navController,
                            modifier = Modifier.align(Alignment.BottomCenter)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun NavigationComponent(modifier: Modifier=Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier.clip(RoundedCornerShape(36.dp)),
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