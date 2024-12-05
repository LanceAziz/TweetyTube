package com.example.tweetytube.presentation.screens.home


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tweetytube.presentation.components.movie_card.MovieCard

@Composable
fun Home() {
    LazyColumn {
        items(3) {
            Spacer(Modifier.height(26.dp))
            Text(
                text = "Trending Movies",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.outline,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LazyRow {
                items(5) {
                    Box(modifier = Modifier.padding(end = 16.dp)) {
                        MovieCard()
                    }
                }
            }
            Spacer(Modifier.height(26.dp))
        }
    }
}