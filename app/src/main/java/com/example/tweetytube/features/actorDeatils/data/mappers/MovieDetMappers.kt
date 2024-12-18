package com.example.tweetytube.features.actorDeatils.data.mappers

import com.example.tweetytube.features.actorDeatils.data.local.MovieDetEntity
import com.example.tweetytube.features.actorDeatils.data.remote.response.MovieDetDto
import com.example.tweetytube.features.actorDeatils.domain.model.MovieDet


fun MovieDetDto.toMovieDetEntity(): MovieDetEntity {
    return MovieDetEntity(
        backdrop_path = backdrop_path ?: "",
        adult = adult == true,
        original_language = original_language ?: "",
        original_title = original_title ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        poster_path = poster_path ?: "",
        release_date = release_date ?: "",
        title = title ?: "",
        video = video == true,
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: 0,
        id = id ?: -1,
        genre_ids = try {
            (genre_ids as? List<*>)
                ?.joinToString(",") { it.toString() }
                ?: "-1,-2"
        } catch (e: Exception) {
            "-1,-2"
        },
    )
}

fun MovieDetEntity.toMovieDet(): MovieDet {
    return MovieDet(
        backdrop_path = backdrop_path,
        adult = adult,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count,
        id = id,
        genre_ids = try {
            genre_ids.split(",").map { it.toInt() }
        } catch (e: Exception) {
            listOf(-1, -2)
        },
    )
}