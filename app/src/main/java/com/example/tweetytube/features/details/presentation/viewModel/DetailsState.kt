package com.example.tweetytube.features.details.presentation.viewModel

import com.example.tweetytube.features.details.domain.model.Credits
import com.example.tweetytube.movie_list.data.repo.local.Movie

data class DetailsState(
    val isMovieLoading: Boolean = false,
    val isCreditsLoading: Boolean = false,
    val currentMovieId: Int = -1,
    val movie: Movie? = null,
    val credits: List<Credits> = emptyList()
)
