package com.example.tweetytube.features.details.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.tweetytube.R
import com.example.tweetytube.core.utils.Urls.Companion.IMAGE_BASE_URL
import com.example.tweetytube.features.details.presentation.components.collectionRow.CollectionRow
import com.example.tweetytube.features.details.presentation.viewModel.DetailsViewModel
import com.example.tweetytube.features.supplementary.loading.LoadingAnimation
import com.example.tweetytube.ui.theme.errorLight
@Composable
fun Details(id: Int, detailsViewModel: DetailsViewModel = hiltViewModel()) {
    val detailsState by detailsViewModel.detailsState.collectAsState()
    LaunchedEffect(id) {
        detailsViewModel.setCurrentMovieId(id)
    }
    if (detailsState.isMovieLoading || detailsState.isCreditsLoading) {
        LoadingAnimation()
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(4.dp)) {
                AsyncImage(
                    model = "${IMAGE_BASE_URL}${detailsState.movie?.backdrop_path}",
                    contentDescription = "Image with rounded corners",
                    modifier = Modifier
                        .height(200.dp)
                        .clip(RoundedCornerShape(28.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .offset(y = 160.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                            .padding(start = 24.dp, end = 24.dp, top = 30.dp, bottom = 180.dp)
                    ) {
                        Column {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Column {
                                    Text(
                                        text = "${detailsState.movie?.title}",
                                        fontSize = 32.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Rating: ${detailsState.movie?.vote_average}",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.outline
                                    )
                                    Text(
                                        text = "Release Date: ${detailsState.movie?.release_date}",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.outline
                                    )
                                }
                            }
                            Column(modifier = Modifier.padding(top = 16.dp)) {
                                Text(
                                    text = "Overview",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "${detailsState.movie?.overview}",
                                    fontSize = 14.sp,
                                )
                            }
                            CollectionRow(title = "Cast", credits = detailsState.credits)
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 120.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Column(
                        modifier = Modifier
                            .shadow(
                                elevation = 10.dp,
                                shape = RoundedCornerShape(32.dp),
                                ambientColor = Color.White
                            )
                            .clip(RoundedCornerShape(32.dp))

                    ) {
                        Column(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .padding(16.dp)
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clickable { TODO("Implement Favorites") },
                                painter = painterResource(id = R.drawable.heart_solid),
                                contentDescription = "Favorite Button",
                                tint = errorLight
                            )
                        }
                    }
                }
            }
        }
    }
}