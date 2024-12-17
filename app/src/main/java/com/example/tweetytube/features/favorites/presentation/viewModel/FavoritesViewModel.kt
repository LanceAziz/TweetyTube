package com.example.tweetytube.features.favorites.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.favorites.domain.repo.FavoritesRepo
import com.example.tweetytube.movie_list.data.repo.local.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject // Correct import
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoritesRepo: FavoritesRepo
) : ViewModel() {

    private val _favoritesState = MutableStateFlow<Resource<List<Movie>>>(Resource.Loading())
    val favoritesState: StateFlow<Resource<List<Movie>>> = _favoritesState

    fun getFavorites(token: String?) {
        viewModelScope.launch {
            _favoritesState.value = Resource.Loading()
            try {
                val favorites = favoritesRepo.getFavorites(token)
                _favoritesState.value = Resource.Success(favorites)
            } catch (e: Exception) {
                _favoritesState.value = Resource.Error(e.message ?: "An error occurred")
            }
        }
    }

    fun addFavorite(token: String?, movieId: Int) {
        viewModelScope.launch {
            try {
                favoritesRepo.addFavorite(token, movieId)
            } catch (e: Exception) {
                _favoritesState.value = Resource.Error(e.message ?: "An error occurred")
            }
        }
    }

    fun removeFavorite(token: String?, movieId: Int) {
        viewModelScope.launch {
            try {
                favoritesRepo.removeFavorite(token, movieId)
            } catch (e: Exception) {
                _favoritesState.value = Resource.Error(e.message ?: "An error occurred")
            }
        }
    }

    fun isFavorited(movieId: Int): Boolean {
        return _favoritesState.value.data?.any { it.id == movieId } == true
    }
}
