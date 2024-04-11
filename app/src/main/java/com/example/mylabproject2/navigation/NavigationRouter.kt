package com.example.mylabproject2.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {

    data object SignUpScreen :Screen()
   data object LoginScreen : Screen()
   data object ForgotPasswordScreen: Screen()
    data object WelcomeScreen: Screen()
    data object HomeScreen: Screen()

    object NavigationRouter {
        var currentScreen: MutableState<Screen> = mutableStateOf(Screen.WelcomeScreen)
        fun navigateTo(destination: Screen){
            currentScreen.value = destination
        }
    }




}