package com.example.tweetytube.features.auth.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetytube.core.utils.Resource
import com.example.tweetytube.features.auth.data.remote.request.LoginRequest
import com.example.tweetytube.features.auth.data.remote.request.SignUpRequest
import com.example.tweetytube.features.auth.domain.model.Auth
import com.example.tweetytube.features.auth.domain.repo.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepo: AuthRepo
) : ViewModel() {
    private var _authState = MutableStateFlow(AuthState())
    val authState: StateFlow<AuthState> = _authState

    fun setSignUpFirstName(value: String) {
        _authState.value = _authState.value.copy(
            signUpFields = _authState.value.signUpFields.copy(
                firstName = value
            )
        )
    }

    fun setSignUpSecondName(value: String) {
        _authState.value = _authState.value.copy(
            signUpFields = _authState.value.signUpFields.copy(
                secondName = value
            )
        )
    }

    fun setSignUpEmail(value: String) {
        _authState.value = _authState.value.copy(
            signUpFields = _authState.value.signUpFields.copy(
                email = value
            )
        )
    }

    fun setSignUpUsername(value: String) {
        _authState.value = _authState.value.copy(
            signUpFields = _authState.value.signUpFields.copy(
                username = value
            )
        )
    }

    fun setSignUpPassword(value: String) {
        _authState.value = _authState.value.copy(
            signUpFields = _authState.value.signUpFields.copy(
                password = value
            )
        )
    }

    fun setLoginUsername(value: String) {
        _authState.value = _authState.value.copy(
            loginFields = _authState.value.loginFields.copy(
                username = value
            )
        )
    }

    fun setLoginPassword(value: String) {
        _authState.value = _authState.value.copy(
            loginFields = _authState.value.loginFields.copy(
                password = value
            )
        )
    }

    private val _response = mutableStateOf<Resource<Auth>>(Resource.Loading())
    val response: State<Resource<Auth>> = _response

    fun signUp(request: SignUpRequest) {
        viewModelScope.launch {
            _response.value = Resource.Loading(true) // Show loading state
            _authState.value = _authState.value.copy(isSignUpLoading = true)
            val result = authRepo.signUp(request) // Call repository
            when (result) {
                is Resource.Success -> {
                    val data = result.data
                    if (data != null) {
                        _response.value = Resource.Success(
                            Auth(
                                message = data.message,
                                username = data.username
                            )
                        )
                        _authState.value = _authState.value.copy(isUserSignedUp = true)
                        _authState.value = _authState.value.copy(isSignUpLoading = false)
                    } else {
                        _response.value = Resource.Error("No data received")
                        _authState.value = _authState.value.copy(isSignUpError = true)
                        _authState.value = _authState.value.copy(isSignUpLoading = false)
                    }
                }

                is Resource.Error -> {
                    _response.value = Resource.Error(result.message ?: "Unknown error")
                    _authState.value = _authState.value.copy(isUserSignedUp = false)
                    _authState.value = _authState.value.copy(isSignUpLoading = false)
                    _authState.value = _authState.value.copy(isSignUpError = true)
                }

                is Resource.Loading -> {
                    _authState.value = _authState.value.copy(isSignUpLoading = false)
                }
            }
        }
    }

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            _response.value = Resource.Loading(true) // Show loading state
            _authState.value = _authState.value.copy(isLoginLoading = false)
            val result = authRepo.login(request) // Call repository
            when (result) {
                is Resource.Success -> {
                    val data = result.data
                    if (data != null) {
                        _response.value = Resource.Success(
                            Auth(
                                message = "Login successful",
                                token = data.access_token
                            )
                        )
                        _authState.value = _authState.value.copy(userToken = data.access_token)
                        _authState.value = _authState.value.copy(isLoginLoading = false)
                    } else {
                        _response.value = Resource.Error("No data received")
                        _authState.value = _authState.value.copy(isLoginLoading = false)
                        _authState.value = _authState.value.copy(isLoginError = true)

                    }
                }

                is Resource.Error -> {
                    _response.value = Resource.Error(result.message ?: "Unknown error")
                    _authState.value = _authState.value.copy(isLoginLoading = false)
                    _authState.value = _authState.value.copy(isLoginError = true)
                }

                is Resource.Loading -> {
                    _authState.value = _authState.value.copy(isLoginLoading = true)
                }
            }
        }
    }
}
