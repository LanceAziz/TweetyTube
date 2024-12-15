package com.example.tweetytube.features.details.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CreditsEntity (
    val adult: Boolean,
    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val gender: Int,
    val known_for_department: String,
    val name: String,
    val order: Int,
    val original_name: String,
    val popularity: Double,
    val profile_path: String,

    @PrimaryKey
    val id: Int,
)