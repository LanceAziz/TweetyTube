package com.example.tweetytube.features.actorDeatils.presentation.components.collectionRow

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tweetytube.features.actorDeatils.domain.model.MovieDet
import com.example.tweetytube.features.actorDeatils.presentation.components.microCard.MicroCard

@Composable
fun CollectionRow(title: String, movies: List<MovieDet>, goToDetails: (Int) -> Unit) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 16.dp)
    )
    LazyRow {
        items(1) {
            movies.forEach {
                MicroCard(id=it.id,image = it.poster_path, name = it.title, type = it.release_date, goToDetails = goToDetails)
                Spacer(Modifier.width(20.dp))
            }
        }
    }
}