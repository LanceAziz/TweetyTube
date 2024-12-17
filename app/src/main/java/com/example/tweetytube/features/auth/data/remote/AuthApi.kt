package com.example.tweetytube.features.auth.data.remote

import com.example.tweetytube.features.auth.data.remote.request.LoginRequest
import com.example.tweetytube.features.auth.data.remote.request.SignUpRequest
import com.example.tweetytube.features.auth.data.remote.response.LoginResponse
import com.example.tweetytube.features.auth.data.remote.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/signingup/v1")
    suspend fun signUp(@Body request: SignUpRequest): Response<SignUpResponse>

    @POST("/accessingApi/v1")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}