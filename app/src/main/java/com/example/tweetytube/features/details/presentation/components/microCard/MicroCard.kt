package com.example.tweetytube.features.details.presentation.components.microCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tweetytube.core.utils.Urls.Companion.IMAGE_BASE_URL

@Composable
fun MicroCard(image: String, name: String, type: String) {
    Column(
        modifier = Modifier.width(180.dp)
    ) {
        AsyncImage(
            model = "${IMAGE_BASE_URL}${image}",
            contentDescription = "Image with rounded corners",
            modifier = Modifier
                .width(180.dp)
                .clip(RoundedCornerShape(28.dp)),
            contentScale = ContentScale.Crop
        )
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