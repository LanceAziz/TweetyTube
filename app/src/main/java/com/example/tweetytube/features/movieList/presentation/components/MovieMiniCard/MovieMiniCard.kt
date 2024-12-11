package com.example.tweetytube.features.movieList.presentation.components.MovieMiniCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tweetytube.R
import com.example.tweetytube.core.utils.Urls.Companion.IMAGE_BASE_URL
import com.example.tweetytube.movie_list.data.repo.local.Movie
import com.example.tweetytube.ui.theme.primaryLight
import com.example.tweetytube.ui.theme.secondaryLight
import kotlin.math.roundToInt

@Composable
fun MovieMIniCard(movieSearch:Movie){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(110.dp)
    ) {
        AsyncImage(
            model = "${IMAGE_BASE_URL}${movieSearch.poster_path}",
            contentDescription = "Movie Thumbnail",
            modifier = Modifier
                .fillMaxHeight()
                .width(80.dp)
                .clip(RoundedCornerShape(14.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 4.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = movieSearch.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.outline,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f) // Ensure title takes available space
                )
                Spacer(modifier = Modifier.width(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = ((movieSearch.vote_average * 10).roundToInt() / 10f).toString(),
                        fontSize = 16.sp,
                        color = primaryLight
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.star_solid),
                        contentDescription = "Rating Star",
                        tint = secondaryLight
                    )
                }
            }
            Text(
                text = movieSearch.overview,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.primary,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}