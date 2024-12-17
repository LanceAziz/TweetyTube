package com.example.tweetytube.features.auth.data.remote

import com.example.tweetytube.BuildConfig
import com.example.tweetytube.core.utils.Urls.Companion.INTEGRATION_API_KEY
import com.example.tweetytube.features.auth.data.remote.request.LoginRequest
import com.example.tweetytube.features.auth.data.remote.request.SignUpRequest
import com.example.tweetytube.features.auth.data.remote.response.LoginResponse
import com.example.tweetytube.features.auth.data.remote.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {
    @POST("signingup/v1")
    suspend fun signUp(
        @Body request: SignUpRequest,
        @Header("ApiKey") apiKey: String = INTEGRATION_API_KEY
    ): Response<SignUpResponse>

    @POST("accessingApi/v1")
    suspend fun login(
        @Body request: LoginRequest,
        @Header("ApiKey") apiKey: String = INTEGRATION_API_KEY
    ): Response<LoginResponse>
}