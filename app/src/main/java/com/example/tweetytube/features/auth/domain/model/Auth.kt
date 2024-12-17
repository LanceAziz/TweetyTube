package com.example.tweetytube.features.auth.domain.model

data class Auth(
    val message: String,
    val username: String? = null,
    val token: String? = null
)