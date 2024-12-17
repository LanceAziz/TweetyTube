package com.example.tweetytube.features.auth.domain.repo

import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.auth.data.remote.request.LoginRequest
import com.example.tweetytube.features.auth.data.remote.request.SignUpRequest
import com.example.tweetytube.features.auth.data.remote.response.LoginResponse
import com.example.tweetytube.features.auth.data.remote.response.SignUpResponse

interface AuthRepo {
    suspend fun signUp(request: SignUpRequest): Resource<SignUpResponse>
    suspend fun login(request: LoginRequest): Resource<LoginResponse>
}