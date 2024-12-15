package com.example.tweetytube.features.details.data.mappers

import com.example.tweetytube.features.details.data.local.CreditsEntity
import com.example.tweetytube.features.details.data.remote.response.CastDto
import com.example.tweetytube.features.details.domain.model.Credits

fun CastDto.toCreditsEntity(): CreditsEntity {
    return CreditsEntity(
        adult = adult ?: false,
        cast_id = cast_id ?: -1,
        character = character ?: "",
        credit_id = credit_id ?: "",
        gender = gender ?: -1,
        id = id ?: -1,
        known_for_department = known_for_department ?: "",
        name = name ?: "",
        order = order ?: -1,
        original_name = original_name ?: "",
        popularity = popularity ?: 0.0,
        profile_path = profile_path ?: ""
    )
}

fun CreditsEntity.toCredits(): Credits {
    return Credits(
        cast_id = cast_id ?: -1,
        character = character ?: "",
        credit_id = credit_id ?: "",
        gender = gender ?: -1,
        id = id ?: -1,
        known_for_department = known_for_department ?: "",
        name = name ?: "",
        profile_path = profile_path ?: ""
    )
}