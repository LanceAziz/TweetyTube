package com.example.tweetytube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.tweetytube.ui.theme.AppTheme
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var selectedIndex by remember { mutableIntStateOf(0) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AnimatedNavigationBar(
                            modifier = Modifier
                                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
                            selectedIndex = selectedIndex,
                            barColor = MaterialTheme.colorScheme.primary,
                            ballColor = MaterialTheme.colorScheme.tertiary,
                            cornerRadius = shapeCornerRadius(200f),
                            ballAnimation = Parabolic(tween(300)),
                            indentAnimation = Height(tween(300))
                        ) {
                            NavBarItems.entries.forEach { item ->
                                Box(modifier = Modifier.padding(vertical = 26.dp)) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.name,
                                        tint = if (selectedIndex == item.ordinal) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.background,
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clickable { selectedIndex = item.ordinal }
                                    )
                                }
                            }
                        }
                    }) { innerPadding ->
                    Text(
                        text = "Feed",
                        modifier = Modifier.padding(innerPadding),
                        fontSize = 64.sp
                    )
                }
            }
        }
    }
}

enum class NavBarItems(val icon: ImageVector) {
    Feed(icon = Icons.Filled.Home),
    Favourites(icon = Icons.Filled.Favorite),
    Profile(icon = Icons.Filled.AccountCircle)
}