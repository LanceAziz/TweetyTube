package com.example.tweetytube.features.favorites.data.repo

import com.example.tweetytube.features.favorites.data.remote.FavoritesApi
import com.example.tweetytube.features.favorites.data.remote.request.ToggleFavoritesRequest
import com.example.tweetytube.features.favorites.domain.repo.FavoritesRepo
import com.example.tweetytube.movie_list.data.repo.local.Movie
import kotlin.Boolean

class FavoritesRepoImp(
    private val favoritesApi: FavoritesApi
) : FavoritesRepo {

    override suspend fun addFavorite(token: String?, movieId: Int) {
        favoritesApi.addFavorite(token, ToggleFavoritesRequest(movieId))
    }

    override suspend fun removeFavorite(token: String?, movieId: Int) {
        favoritesApi.removeFavorite(token, ToggleFavoritesRequest(movieId))
    }

    override suspend fun getFavorites(token: String?): List<Movie> {
        return favoritesApi.getFavorites(token).results.map {
            Movie(
                backdrop_path = it.backdrop_path,
                overview = it.overview,
                poster_path = it.poster_path,
                release_date = it.release_date,
                title = it.title,
                vote_average = it.vote_average,
                id = it.id,
                adult = it.adult,
                genre_ids = it.genre_ids,
                original_language = it.original_language,
                original_title = it.original_title,
                popularity = it.popularity,
                video = it.video,
                vote_count = it.vote_count,
                category = it.category
            )
        }
    }
}