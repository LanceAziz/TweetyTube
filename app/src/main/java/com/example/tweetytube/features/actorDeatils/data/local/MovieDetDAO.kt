package com.example.tweetytube.features.actorDeatils.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.tweetytube.movie_list.data.repo.local.MovieEntity

@Dao
interface MovieDetDAO {
    @Upsert
    suspend fun upsertCreditList(movieDet: List<MovieDetEntity>)

    @Query("SELECT * FROM MovieDetEntity WHERE id = :castId")
    suspend fun getMovieByCreditId(castId: Int): List<MovieDetEntity>
}