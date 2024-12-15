package com.example.tweetytube.features.movieList.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetytube.core.utils.Category
import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    private val _searchState = MutableStateFlow(SearchState())
    val searchState: StateFlow<SearchState> = _searchState
    val searchText get() = _searchState.value.searchText
    val filter get() = _searchState.value.filter
    val getSearchResult get() = _searchState.value.searchResult

    fun setSearchText(value: String) {
        _searchState.value = _searchState.value.copy(searchText = value)
    }

    fun setFilter(value: String) {
        _searchState.value = _searchState.value.copy(filter = value)
    }


    val popularMovieList get() = _movieListState.value.popularMovieList
    val upcomingMovieList get() = _movieListState.value.upcomingMovieList
    val topRatedMovieList get() = _movieListState.value.topRatedMovieList

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

    private var searchJob: Job? = null

    fun reboundedSearch(newText: String, filter: String) {
//        setSearchText(newText)
        searchJob?.cancel()

        // Launch a new debounce job
        searchJob = viewModelScope.launch {
            delay(500) // Wait for 500 milliseconds
            movieQuery(newText, filter) // Execute the search after delay
        }
    }

    fun movieQuery(text: String, category: String): Unit {
        if (text.isEmpty()) {
            _searchState.value = _searchState.value.copy(searchResult = emptyList())
        } else {
            val searchResult = when (category) {
                Category.POPULAR -> {
                    popularMovieList.filter { movie ->
                        movie.title.lowercase().contains(text.lowercase())
                    }
                }

                Category.UPCOMING -> {
                    upcomingMovieList.filter { movie ->
                        movie.title.lowercase().contains(text.lowercase())
                    }
                }

                Category.TOP_RATED -> {
                    topRatedMovieList.filter { movie ->
                        movie.title.lowercase().contains(text.lowercase())
                    }
                }

                else -> {
                    emptyList()
                }
            }
            _searchState.value = _searchState.value.copy(searchResult = searchResult)
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
//                                delay(5000)
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