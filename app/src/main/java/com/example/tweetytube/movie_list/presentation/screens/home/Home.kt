package com.example.tweetytube.movie_list.presentation.screens.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tweetytube.movie_list.presentation.components.movie_card.MovieCard
import kotlin.math.absoluteValue

@Composable
fun Home() {
    val images = listOf(
        "https://image.tmdb.org/t/p/w342/yh64qw9mgXBvlaWDi7Q9tpUBAvH.jpg",
        "https://image.tmdb.org/t/p/w342/aosm8NMQ3UyoBVpSxyimorCQykC.jpg",
        "https://image.tmdb.org/t/p/w342/uQhYBxOVFU6s9agD49FnGHwJqG5.jpg",
        "https://image.tmdb.org/t/p/w342/cNtAslrDhk1i3IOZ16vF7df6lMy.jpg",
        "https://image.tmdb.org/t/p/w342/pnXLFioDeftqjlCVlRmXvIdMsdP.jpg"
    )
    LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
        items(3) {
            val pagerState = rememberPagerState(pageCount = { images.size })
            Text(
                text = "Trending Movies",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.outline,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(
                    start = if (pagerState.currentPage == 0) 8.dp else 32.dp,
                    end = if (pagerState.currentPage == pagerState.pageCount - 1) 8.dp else 32.dp
                )
            ) { index ->
                val pageOffset =
                    (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
                val alpha =
                    if (pageOffset.absoluteValue < 1f) 1f - pageOffset.absoluteValue * 0.4f else 0.5f
                val translationX = pageOffset * 100.dp.value
                val scale = 1f - pageOffset.absoluteValue * 0.1f

                val isFirstCard = index == 0
                val isLastCard = index == images.size - 1

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
                    MovieCard(image = images[index])
                }
            }
        }
    }
}