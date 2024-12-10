package com.example.tweetytube.features.movieList.domain.repo

import com.example.tweetytube.movie_list.data.repo.local.Movie
import com.example.tweetytube.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepo {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(id: Int): Flow<Resource<Movie>>
}