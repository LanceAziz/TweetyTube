package com.example.tweetytube.features.actorDeatils.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.tweetytube.core.utils.Urls.Companion.IMAGE_BASE_URL
import com.example.tweetytube.features.actorDeatils.presentation.components.collectionRow.CollectionRow
import com.example.tweetytube.features.actorDeatils.presentation.viewModel.ActorDetailsViewModel
import com.example.tweetytube.features.supplementary.loading.LoadingAnimation

@Composable
fun ActorDetails(
    id: Int,
    actorName: String,
    actorImage: String,
    actorRole: String,
    actorDetailsViewModel: ActorDetailsViewModel = hiltViewModel(),
    goToDetails: (Int) -> Unit
) {
    val actorDetailsState by actorDetailsViewModel.actorDetailsState.collectAsState()
    LaunchedEffect(id) {
        actorDetailsViewModel.setCurrentCreditId(id)
    }
    if (actorDetailsState.isMoviesLoading || actorDetailsState.isCreditLoading) {
        LoadingAnimation()
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(4.dp)) {
                AsyncImage(
                    model = "${IMAGE_BASE_URL}${actorImage}",
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
                                        text = actorName,
                                        fontSize = 32.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Role: $actorRole",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.outline
                                    )
                                    Text(
                                        text = "id: ${actorDetailsState.movies.size}",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.outline
                                    )
                                }
                            }
                            CollectionRow(
                                title = "Related Movies",
                                movies = actorDetailsState.movies,
                                goToDetails = goToDetails
                            )
                        }
                    }
                }
            }
        }
    }
}