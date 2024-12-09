package com.example.tweetytube.movie_list.presentation.components.movies_collection_row

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tweetytube.movie_list.data.repo.local.Movie
import com.example.tweetytube.movie_list.presentation.components.movie_card.MovieCard
import kotlin.math.absoluteValue

@Composable
fun MoviesCollectionRow(rowTitle: String, movies: List<Movie>) {
    Column {
        val pagerState = rememberPagerState(pageCount = { movies.size })
        Text(
            text = rowTitle,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.outline,
            fontSize = 26.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth(),
            contentPadding = PaddingValues(
                start = if (pagerState.currentPage == 0) 0.dp else 32.dp,
                end = if (pagerState.currentPage == pagerState.pageCount - 1) 0.dp else 32.dp
            )
        ) { index ->
            val pageOffset =
                (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
            val alpha =
                if (pageOffset.absoluteValue < 1f) 1f - pageOffset.absoluteValue * 0.4f else 0.5f
            val translationX = pageOffset * 100.dp.value
            val scale = 1f - pageOffset.absoluteValue * 0.1f

            val isFirstCard = index == 0
            val isLastCard = index == movies.size - 1

            Box(modifier = Modifier
                .graphicsLayer {
                    this.translationX = translationX
                    this.alpha = alpha
                    this.scaleX = scale
                    this.scaleY = scale
                }
                .width(350.dp)
                .padding(
                    start = if (isFirstCard) 0.dp else 16.dp,
                    end = if (isLastCard) 0.dp else 16.dp
                )) {
                MovieCard(movie = movies[index])
            }
        }
    }
}