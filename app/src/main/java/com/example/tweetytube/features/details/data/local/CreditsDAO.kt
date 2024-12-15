package com.example.tweetytube.features.details.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface CreditsDAO {
    @Upsert
    suspend fun upsertMovieList(casts: List<CreditsEntity>)

    @Query("SELECT * FROM CreditsEntity WHERE id = :movieId")
    suspend fun getCastByMovieId(movieId: Int): List<CreditsEntity>
}