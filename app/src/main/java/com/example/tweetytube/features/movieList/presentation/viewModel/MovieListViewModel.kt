package com.example.tweetytube.features.movieList.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo
import com.example.tweetytube.core.utils.Category
import com.example.tweetytube.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieListRepository: MovieListRepo
) : ViewModel() {

    private var _movieListState = MutableStateFlow(MovieListState())
    val movieListState = _movieListState.asStateFlow()

    init {
        fetchAllMovies()
    }

    fun onEvent(event: MovieListUiEvent) {
        if (event is MovieListUiEvent.Paginate) {
            fetchMovies(true, event.category)
        }
    }

    private fun fetchAllMovies() {
        viewModelScope.launch {
            listOf(
                async { fetchMovies(false, Category.POPULAR) },
                async { fetchMovies(false, Category.UPCOMING) },
                async { fetchMovies(false, Category.TOP_RATED) }
            ).forEach { it.await() }
        }
    }

    private fun fetchMovies(forceFetchFromRemote: Boolean, category: String) {
        viewModelScope.launch {
            _movieListState.update { state ->
                state.copy(
                    currentCategory = category,
                    isLoadingPopular = category == Category.POPULAR,
                    isLoadingUpcoming = category == Category.UPCOMING,
                    isLoadingTopRated = category == Category.TOP_RATED
                )
            }

            val currentPage = when (category) {
                Category.POPULAR -> movieListState.value.popularMovieListPage
                Category.UPCOMING -> movieListState.value.upcomingMovieListPage
                Category.TOP_RATED -> movieListState.value.topRatedMovieListPage
                else -> 1
            }

            movieListRepository.getMovieList(forceFetchFromRemote, category, currentPage)
                .collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            Log.e("MovieListViewModel", result.message ?: "Unknown error")
                            _movieListState.update { state ->
                                state.copy(
                                    isLoadingPopular = false,
                                    isLoadingUpcoming = false,
                                    isLoadingTopRated = false
                                )
                            }
                        }

                        is Resource.Success -> {
                            result.data?.let { movieList ->
                                _movieListState.update { state ->
                                    when (category) {
                                        Category.POPULAR -> state.copy(
                                            popularMovieList = state.popularMovieList + movieList,
                                            popularMovieListPage = currentPage + 1,
                                            isLoadingPopular = false
                                        )

                                        Category.UPCOMING -> state.copy(
                                            upcomingMovieList = state.upcomingMovieList + movieList,
                                            upcomingMovieListPage = currentPage + 1,
                                            isLoadingUpcoming = false
                                        )

                                        Category.TOP_RATED -> state.copy(
                                            topRatedMovieList = state.topRatedMovieList + movieList,
                                            topRatedMovieListPage = currentPage + 1,
                                            isLoadingTopRated = false
                                        )

                                        else -> state
                                    }
                                }
                            }
                        }

                        is Resource.Loading -> {
                            _movieListState.update { state ->
                                when (category) {
                                    Category.POPULAR -> state.copy(isLoadingPopular = result.isLoading)
                                    Category.UPCOMING -> state.copy(isLoadingUpcoming = result.isLoading)
                                    Category.TOP_RATED -> state.copy(isLoadingTopRated = result.isLoading)
                                    else -> state
                                }
                            }
                        }
                    }
                }
        }
    }
}