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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.tweetytube.core.navigation.NavigationComponent
import com.example.tweetytube.features.search.presentation.viewModel.SearchViewModel
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
                val searchViewModel: SearchViewModel = viewModel()
                Scaffold(
                    topBar = {
                        TopBar(
                            navController = navController,
                            searchViewModel = searchViewModel
                        )
                    },
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