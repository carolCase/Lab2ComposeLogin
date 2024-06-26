package com.example.mylabproject2.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.mylabproject2.data.SignUpViewModel
import com.example.mylabproject2.data.SignUpUIEvent
import com.example.mylabproject2.navigation.Screen

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel()) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(45.dp),
    )

    {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextComponent(value = "Be one of us")
            HeadingComponent(value = "Register new account")

            Spacer(modifier = Modifier.height(20.dp))

            MyTextField(
                labelValue = "Enter Email",
                painterResource(id = R.drawable.baseline_email_24),
                onTextSelected = {
                   signUpViewModel.onEvent(SignUpUIEvent.EmailChanged(it))
                },errorStatus = signUpViewModel.signUpUIState.value.emailError)

            PasswordTextField(
                labelValue = "Enter password", painterResource(id = R.drawable.baseline_password_24),
                onTextSelected = {
                  signUpViewModel.onEvent(SignUpUIEvent.PasswordChanged(it))
                },errorStatus = signUpViewModel.signUpUIState.value.passwordError
            )
            CheckboxComponent(value = "Accept Privacy Policy and Terms of Use")


            ButtonComponent(value = "Register", onButtonClicked = {

                signUpViewModel.onEvent(SignUpUIEvent.RegisterButton)
            },isEnabled = signUpViewModel.allErrorHandlingPassed.value)// true


            Spacer(modifier = Modifier.height(30.dp))

            DividerComponent()
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape))


        }

    }
    BackHandler {
    Screen.NavigationRouter.navigateTo(Screen.WelcomeScreen)
}

}


@Preview
@Composable
fun DefaultPreviewSignUp() {
    SignUpScreen()
}