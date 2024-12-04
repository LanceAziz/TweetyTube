package com.example.tweetytube.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tweetytube.R
import com.example.tweetytube.presentation.screens.Screen
import com.example.tweetytube.presentation.screens.Screen.*
import com.example.tweetytube.ui.theme.*
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius


enum class NavBarItems(@DrawableRes val icon: Int, val navigation: Screen) {
    Favourite(icon = R.drawable.heart_solid, navigation = FavoriteScreen),
    Feed(icon = R.drawable.house_solid, navigation = HomeScreen),
    Profile(icon = R.drawable.user_solid, navigation = ProfileScreen)
}

@Composable
fun BottomNavbar(navController: NavController) {
    var selectedIndex by remember { mutableIntStateOf(1) }
    AnimatedNavigationBar(
        modifier = Modifier
            .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
        selectedIndex = selectedIndex,
        barColor = primaryLight,
        ballColor = secondaryLight,
        cornerRadius = shapeCornerRadius(200f),
        ballAnimation = Parabolic(tween(300)),
        indentAnimation = Height(tween(300))
    ) {
        NavBarItems.entries.forEach { item ->
            Box(modifier = Modifier.padding(vertical = 26.dp)) {
                Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.name,
                    tint = if (selectedIndex == item.ordinal) secondaryLight else MaterialTheme.colorScheme.background,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            onClick = {
                                selectedIndex = item.ordinal
                                navController.navigate(item.navigation)
                            },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                )
            }
        }
    }
}