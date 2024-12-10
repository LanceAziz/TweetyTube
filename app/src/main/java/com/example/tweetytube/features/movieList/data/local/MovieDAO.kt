package com.example.tweetytube.movie_list.data.repo.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MovieDAO {
    @Upsert
    suspend fun upsertMovieList(movies: List<MovieEntity>)

    @Query("SELECT * FROM MovieEntity WHERE id = :id")
    suspend fun getMovieById(id: Int): MovieEntity

    @Query("SELECT * FROM MovieEntity WHERE category = :category")
    suspend fun getMoviesByCategory(category: String): List<MovieEntity>
}