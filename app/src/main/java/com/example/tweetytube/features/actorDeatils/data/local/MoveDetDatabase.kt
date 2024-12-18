package com.example.tweetytube.features.actorDeatils.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieDetEntity::class],
    version = 1
)
abstract class MovieDetDatabase: RoomDatabase() {
    abstract val movieDetDao: MovieDetDAO
}