package com.example.tweetytube.features.auth.presentation.viewModel

import com.example.tweetytube.features.auth.data.remote.request.LoginRequest
import com.example.tweetytube.features.auth.data.remote.request.SignUpRequest

data class AuthState(
    val loginFields: LoginRequest = LoginRequest("", ""),
    val isLoginPasswordVisible: Boolean = false,
    val isLoginLoading: Boolean = false,
    val isLoginError: Boolean = false,
    val userToken: String? = null,

    val signUpFields: SignUpRequest = SignUpRequest("", "", "", "", ""),
    val isSignUpPasswordVisible: Boolean = false,
    val isSignUpLoading: Boolean = false,
    val isSignUpError: Boolean = false,
    val isUserSignedUp: Boolean = false,

    )