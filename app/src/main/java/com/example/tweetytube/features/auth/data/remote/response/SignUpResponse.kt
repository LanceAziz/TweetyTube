package com.example.tweetytube.features.auth.data.remote.response

data class SignUpResponse(
    val status: String,
    val message: String,
    val username: String,
    val role: String
)