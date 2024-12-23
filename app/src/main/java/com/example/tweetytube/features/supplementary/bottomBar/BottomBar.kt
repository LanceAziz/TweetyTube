package com.example.tweetytube.features.supplementary.bottomBar

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tweetytube.R
import com.example.tweetytube.core.utils.Screen
import com.example.tweetytube.ui.theme.*
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius


enum class NavBarItems(val text: String, @DrawableRes val icon: Int, val navigation: Screen) {
    Feed(text = "Home", icon = R.drawable.house_solid, navigation = Screen.HomeScreen),
    Favourite(text = "Fav", icon = R.drawable.heart_solid, navigation = Screen.FavoriteScreen),

//    Profile(text = "Profile", icon = R.drawable.user_solid, navigation = Screen.ProfileScreen)
}

@Composable
fun BottomNavbar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    AnimatedNavigationBar(
        modifier = modifier
            .padding()
            .background(Color.Transparent),
        selectedIndex = selectedIndex,
        barColor = primaryLight,
        ballColor = secondaryLight,
        cornerRadius = shapeCornerRadius(200f),
        ballAnimation = Parabolic(tween(300)),
        indentAnimation = Height(tween(300))
    ) {
        NavBarItems.entries.forEach { item ->
            Column(modifier = Modifier.padding(vertical = 26.dp), horizontalAlignment = Alignment.CenterHorizontally) {
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