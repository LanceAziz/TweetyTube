package com.example.tweetytube.features.supplementary.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.tweetytube.R
import com.example.tweetytube.ui.theme.primaryLight
import kotlinx.coroutines.delay

@Composable
fun LoadingAnimation() {
    val composition =
        rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.tweeting_loading))
    var showText by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition = composition.value,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(200.dp).padding(bottom = 16.dp)
        )
        if (showText) {
            Text(text = "You may need to check your")
            Text(text = "Internet Connection", color = primaryLight, fontSize = 30.sp)
        }
        LaunchedEffect(Unit) {
            delay(3000)
            showText = true
        }
    }


}
