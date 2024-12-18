package com.example.tweetytube.features.actorDeatils.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.actorDeatils.domain.repo.MovieDetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActorDetailsViewModel @Inject constructor(
    private val movieDetailsRepository: MovieDetRepo,
) : ViewModel() {

    private var _actorDetailsState = MutableStateFlow(ActorDetailsState())
    val actorDetailsState = _actorDetailsState.asStateFlow()


    fun setCurrentCreditId(value: Int) {
        _actorDetailsState.value = _actorDetailsState.value.copy(currentCreditId = value)
        getMovies(value)
    }

    private fun getMovies(id: Int) {
        viewModelScope.launch {

            _actorDetailsState.update {
                it.copy(
                    isMoviesLoading = true,
                    movies = emptyList()
                )
            }

            movieDetailsRepository.getMovieDet(id).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _actorDetailsState.update {
                            it.copy(isMoviesLoading = false)
                        }
                    }

                    is Resource.Loading -> {
                        _actorDetailsState.update {
                            it.copy(isMoviesLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { movies ->
                            _actorDetailsState.update {
                                it.copy(movies = movies)
                            }
                        }
                    }
                }
            }
        }
    }
}