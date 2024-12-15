package com.example.tweetytube.features.details.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CreditsEntity::class],
    version = 1
)
abstract class CreditsDatabase: RoomDatabase() {
    abstract val creditsDao: CreditsDAO
}