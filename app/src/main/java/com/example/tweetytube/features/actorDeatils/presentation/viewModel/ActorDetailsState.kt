package com.example.tweetytube.features.actorDeatils.presentation.viewModel

import com.example.tweetytube.features.actorDeatils.domain.model.MovieDet
import com.example.tweetytube.features.details.domain.model.Credits
import com.example.tweetytube.movie_list.data.repo.local.Movie

data class ActorDetailsState(
    val isMoviesLoading: Boolean = false,
    val isCreditLoading: Boolean = false,
    val currentCreditId: Int = -1,
    val credit: Credits? = null,
    val movies: List<MovieDet> = emptyList()
)
