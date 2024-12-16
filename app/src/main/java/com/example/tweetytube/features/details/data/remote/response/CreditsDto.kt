package com.example.tweetytube.features.details.data.remote.response

import com.google.gson.annotations.SerializedName

data class CreditsDto(
    @SerializedName("cast")
    val castDto: List<CastDto>,
    @SerializedName("crew")
    val crewDto: List<CrewDto>,
    val id: Int
)