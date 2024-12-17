package com.example.tweetytube.features.auth.data.remote.request

data class SignUpRequest(
    val username: String,
    val password: String,
    val firstName: String,
    val secondName: String,
    val email: String
)