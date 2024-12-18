package com.example.tweetytube.features.actorDeatils.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieDetListDto(
    @SerializedName("cast")
    val movieDetDto: List<MovieDetDto>,
    @SerializedName("crew")
    val crewDto: List<CrewDto>,
    val id: Int
)