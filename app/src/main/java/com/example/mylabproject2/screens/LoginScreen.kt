package com.example.mylabproject2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.mylabproject2.R
import com.example.mylabproject2.components.ButtonComponent
import com.example.mylabproject2.components.ClickableTextComponent
import com.example.mylabproject2.components.HeadingComponent
import com.example.mylabproject2.components.MyTextField
import com.example.mylabproject2.components.PasswordTextField
import com.example.mylabproject2.data.LoginUIEvent
import com.example.mylabproject2.data.LoginViewModel
import com.example.mylabproject2.data.SignUpUIEvent

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(45.dp),
    ){
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center)
        {
            HeadingComponent(value = "Login")
            MyTextField(labelValue = "Enter Username",
                painterResource(id = R.drawable.baseline_account_box_24), onTextSelected = {
                    loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                },errorStatus = loginViewModel.loginUIState.value.emailError)
            PasswordTextField(labelValue = "Enter Password",
                painterResource(id = R.drawable.baseline_password_24), onTextSelected = {
                    loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                },errorStatus = loginViewModel.loginUIState.value.passwordError)
            Spacer(modifier = Modifier.height(30.dp))
            ClickableTextComponent(value = "Forgot Password")
            Spacer(modifier = Modifier.height(25.dp))
            ButtonComponent(value = "Login", onButtonClicked = {
                loginViewModel.onEvent(LoginUIEvent.LoginButton)
            },isEnabled = loginViewModel.allErrorHandlingPassed.value)


        }

    }




}

