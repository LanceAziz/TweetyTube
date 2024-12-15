package com.example.tweetytube.features.details.data.remote.response

data class CreditsDto(
    val castDto: List<CastDto>,
    val crewDto: List<CrewDto>,
    val id: Int
)