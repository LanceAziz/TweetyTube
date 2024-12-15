package com.example.tweetytube.movie_list.data.repo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tweetytube.features.details.data.local.CreditsDAO
import com.example.tweetytube.features.details.data.local.CreditsEntity

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDAO
}