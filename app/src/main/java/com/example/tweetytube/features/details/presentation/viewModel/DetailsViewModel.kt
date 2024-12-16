package com.example.tweetytube.features.details.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.details.domain.repo.CreditsRepo
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val movieListRepository: MovieListRepo,
    private val creditsRepository: CreditsRepo
) : ViewModel() {

    private var _detailsState = MutableStateFlow(DetailsState())
    val detailsState = _detailsState.asStateFlow()

    //update
    private val movieId = _detailsState.value.currentMovieId

    fun setCurrentMovieId(value: Int) {
        _detailsState.value = _detailsState.value.copy(currentMovieId = value)
        getMovie(value)
        getCredits(value)
    }

    private fun getMovie(id: Int) {
        viewModelScope.launch {
            _detailsState.update {
                it.copy(isMovieLoading = true)
            }

            movieListRepository.getMovie(id).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _detailsState.update {
                            it.copy(isMovieLoading = false)
                        }
                    }

                    is Resource.Loading -> {
                        _detailsState.update {
                            it.copy(isMovieLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { movie ->
                            _detailsState.update {
                                it.copy(movie = movie)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getCredits(id: Int) {
        viewModelScope.launch {

            _detailsState.update {
                it.copy(
                    isCreditsLoading = true,
                    credits = emptyList()
                )
            }

            creditsRepository.getCredits(id).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _detailsState.update {
                            it.copy(isCreditsLoading = false)
                        }
                    }

                    is Resource.Loading -> {
                        _detailsState.update {
                            it.copy(isCreditsLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { credits ->
                            _detailsState.update {
                                it.copy(credits = credits)
                            }
                        }
                    }
                }
            }
        }
    }
}























