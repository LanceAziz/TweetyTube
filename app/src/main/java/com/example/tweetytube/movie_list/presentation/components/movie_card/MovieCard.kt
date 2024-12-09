package com.example.tweetytube.movie_list.presentation.components.movie_card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tweetytube.R
import com.example.tweetytube.movie_list.data.repo.local.Movie
import com.example.tweetytube.movie_list.data.repo.remote.MoviesApi.Companion.IMAGE_BASE_URL
import com.example.tweetytube.ui.theme.*
import kotlin.math.roundToInt
import kotlin.math.roundToLong

@Composable
fun MovieCard(movie:Movie) {
    Column {
        Box {
            AsyncImage(
                model = "${IMAGE_BASE_URL}${movie.poster_path}",
                contentDescription = "Image with rounded corners",
                modifier = Modifier
                    .height(450.dp)
                    .clip(RoundedCornerShape(28.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, end = 18.dp),
                horizontalAlignment = Alignment.End,
            ) {
                Icon(
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { TODO("Implement Favorites") },
                    painter = painterResource(id = R.drawable.heart_solid),
                    contentDescription = "Favorite Button",
                    tint = secondaryLight
                )
            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, top = 18.dp)
        ) {
            Text(
                text = movie.title,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = MaterialTheme.colorScheme.outline,
            )
            Text(
                text = movie.vote_average.toString(),
                fontSize = 14.sp,
                color = primaryLight
            )
        }
    }
}