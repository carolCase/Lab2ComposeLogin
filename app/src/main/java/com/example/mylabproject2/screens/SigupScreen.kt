package com.example.mylabproject2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mylabproject2.R
import com.example.mylabproject2.components.ButtonComponent
import com.example.mylabproject2.components.CheckboxComponent
import com.example.mylabproject2.components.DividerComponent
import com.example.mylabproject2.components.HeadingComponent
import com.example.mylabproject2.components.TextComponent
import com.example.mylabproject2.components.MyTextField
import com.example.mylabproject2.components.PasswordTextField
import com.example.mylabproject2.data.LoginViewModel
import com.example.mylabproject2.data.UIEvent

@Composable
fun SignUpScreen(loginViewModel: LoginViewModel = viewModel()) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(45.dp),
    )
    {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            TextComponent(value = "Hi' there!!")
            HeadingComponent(value = "Register new account")

            Spacer(modifier = Modifier.height(20.dp))

            MyTextField(
                labelValue = "Enter Username",
                painterResource(id = R.drawable.baseline_account_box_24),
                onTextSelected = {
                   loginViewModel.onEvent(UIEvent.UserNameChanged(it))
                },errorStatus = loginViewModel.registrationUIState.value.userNameError)

            PasswordTextField(
                labelValue = "Enter password", painterResource(id = R.drawable.baseline_password_24),
                onTextSelected = {
                  loginViewModel.onEvent(UIEvent.PasswordChanged(it))
                },errorStatus = loginViewModel.registrationUIState.value.passwordError
            )
            CheckboxComponent(value = "Accept Privacy Policy and Terms of Use")


            ButtonComponent(value = "Register", onButtonClicked = {
                loginViewModel.onEvent(UIEvent.RegisterButton)
            })
            Spacer(modifier = Modifier.height(30.dp))
            DividerComponent()
        }

    }


}


@Preview
@Composable
fun DefaultPreviewSignUp() {
    SignUpScreen()
}