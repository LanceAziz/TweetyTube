package com.example.tweetytube.features.auth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.tweetytube.R
import com.example.tweetytube.core.utils.Screen
import com.example.tweetytube.features.auth.data.remote.request.LoginRequest
import com.example.tweetytube.features.auth.presentation.viewModel.AuthViewModel
import com.example.tweetytube.features.supplementary.loading.LoadingAnimation
import com.example.tweetytube.ui.theme.bgDark
import com.example.tweetytube.ui.theme.bgLight
import com.example.tweetytube.ui.theme.errorLight
import com.example.tweetytube.ui.theme.outlineLight
import com.example.tweetytube.ui.theme.primaryLight
import com.example.tweetytube.ui.theme.secondaryLight

@Composable
fun Login(navController: NavHostController, authViewModel: AuthViewModel) {
    val authState = authViewModel.authState.collectAsStateWithLifecycle()
    val isDarkTheme = isSystemInDarkTheme()

    if (authState.value.isLoginLoading) {
        LoadingAnimation()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Image(
                    painter = painterResource(if (isDarkTheme) R.drawable.tweety_login_dark else R.drawable.tweety_login_light),
                    contentDescription = "Tweety Tube Logo",
                    modifier = Modifier
                        .size(300.dp)
                )
            }
            OutlinedTextField(
                value = authState.value.loginFields.username,
                onValueChange = { authViewModel.setLoginUsername(it) },
                placeholder = { Text("UserName") },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = primaryLight,
                    unfocusedBorderColor = outlineLight,
                    cursorColor = secondaryLight,
                ),
                shape = RoundedCornerShape(32.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = authState.value.loginFields.password,
                onValueChange = { authViewModel.setLoginPassword(it) },
                placeholder = { Text("Password") },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = primaryLight,
                    unfocusedBorderColor = outlineLight,
                    cursorColor = secondaryLight,
                ),
                shape = RoundedCornerShape(32.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = {
                    authViewModel.login(
                        LoginRequest(
                            username = authState.value.loginFields.username,
                            password = authState.value.loginFields.password
                        )
                    )
                    if (!authState.value.isLoginLoading && !authState.value.userToken.isNullOrBlank()) {
                        navController.navigate(Screen.HomeScreen)
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = if (isDarkTheme) bgLight else bgDark,
                    containerColor = if (!authState.value.isLoginError) primaryLight else errorLight
                )
            ) {
                Text(
                    text = "Login",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Not a member yet? Signup",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                color = primaryLight,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.SignUpScreen)
                }
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Home!",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                color = primaryLight,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.HomeScreen)
                }
            )
        }
    }
}
