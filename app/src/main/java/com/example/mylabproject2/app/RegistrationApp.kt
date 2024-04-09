package com.example.mylabproject2.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mylabproject2.data.LoginViewModel
import com.example.mylabproject2.data.SignUpViewModel

import com.example.mylabproject2.navigation.Screen
import com.example.mylabproject2.screens.ForgotPassword
import com.example.mylabproject2.screens.HomeScreen
import com.example.mylabproject2.screens.LoginScreen
import com.example.mylabproject2.screens.SignUpScreen
import com.example.mylabproject2.screens.WelcomeScreen

@Composable
fun RegistrationApp() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White)
    {
  Crossfade(targetState = Screen.NavigationRouter.currentScreen, label = "") {
      currentState->
      when(currentState.value){
          is Screen.WelcomeScreen->{
              WelcomeScreen()
          }
          is Screen.SignUpScreen ->{
              SignUpScreen()
          }
          is Screen.LoginScreen ->{
              LoginScreen(LoginViewModel())
          }
          is Screen.ForgotPasswordScreen->{
              ForgotPassword()
          }
          is Screen.HomeScreen->{
            HomeScreen(SignUpViewModel())
          }
      }
  }

    }
}



/*The Crossfade composable is used to animate transitions
between different states of a UI. It takes two states (targetState and label)
and a content lambda. In this case, targetState is set to Screen.NavigationRouter.currentScreen,
which likely represents the current screen of the application. label is an optional parameter for
    accessibility purposes.*/
/*
This is a when statement that switches based on the value of currentState.
value, which represents the current screen. Depending on the value, it inflates and
displays the appropriate screen using WelcomeScreen(), SignUpScreen(), LoginScreen(), or ForgotPassword()
composable functions.*/
