package com.example.tweetytube.features.actorDeatils.presentation.components.microCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tweetytube.R
import com.example.tweetytube.core.utils.Urls.Companion.IMAGE_BASE_URL
import com.example.tweetytube.ui.theme.bgDark
import com.example.tweetytube.ui.theme.bgLight

@Composable
fun MicroCard(id: Int, image: String, name: String, type: String, goToDetails: (Int) -> Unit) {
    val isDarkTheme = isSystemInDarkTheme()
    Column(
        modifier = Modifier.width(180.dp).clickable{
            goToDetails(id)
        }
    ) {
        if (image.isNotEmpty()) {
            AsyncImage(
                model = "${IMAGE_BASE_URL}${image}",
                contentDescription = "Image with rounded corners",
                modifier = Modifier
                    .width(180.dp)
                    .clip(RoundedCornerShape(28.dp)),
                contentScale = ContentScale.Crop
            )
        } else {
            Column(
                modifier = Modifier
                    .width(180.dp)
                    .height(270.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(if (isDarkTheme) bgLight else bgDark),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(
                        if (isDarkTheme) {
                            R.drawable.tweety_error_light
                        } else {
                            R.drawable.tweety_error_dark
                        }
                    ),
                    contentDescription = "Tweety Tube Logo",
                    modifier = Modifier
                        .size(150.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.outline,
                textAlign = TextAlign.Center

            )
            Text(
                text = type,
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.outline,
                textAlign = TextAlign.Center
            )
        }
    }
}