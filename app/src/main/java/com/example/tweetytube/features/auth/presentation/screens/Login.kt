package com.example.tweetytube.features.auth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tweetytube.R
import com.example.tweetytube.ui.theme.primaryLight

@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryLight),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.tweety_login),
            contentDescription = "Tweety Tube Logo",
            modifier = Modifier
                .size(70.dp)
        )
    }
}
