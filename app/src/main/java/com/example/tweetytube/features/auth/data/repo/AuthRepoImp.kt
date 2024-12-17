package com.example.tweetytube.features.auth.data.repo

import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.auth.data.remote.AuthApi
import com.example.tweetytube.features.auth.data.remote.request.LoginRequest
import com.example.tweetytube.features.auth.data.remote.request.SignUpRequest
import com.example.tweetytube.features.auth.data.remote.response.LoginResponse
import com.example.tweetytube.features.auth.data.remote.response.SignUpResponse
import com.example.tweetytube.features.auth.domain.repo.AuthRepo

class AuthRepoImp(private val authApi: AuthApi) : AuthRepo {

    override suspend fun signUp(request: SignUpRequest): Resource<SignUpResponse> {
        return try {
            val response = authApi.signUp(request)
            if (response.isSuccessful) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error(response.errorBody()?.string() ?: "Unknown error")
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }

    override suspend fun login(request: LoginRequest): Resource<LoginResponse> {
        return try {
            val response = authApi.login(request)
            if (response.isSuccessful) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error(response.errorBody()?.string() ?: "Unknown error")
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}
