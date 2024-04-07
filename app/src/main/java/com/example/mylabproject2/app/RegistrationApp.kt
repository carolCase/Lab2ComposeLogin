package com.example.mylabproject2.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mylabproject2.data.UIEvent
import com.example.mylabproject2.navigation.Screen
import com.example.mylabproject2.screens.LoginScreen
import com.example.mylabproject2.screens.SignUpScreen

@Composable
fun RegistrationApp() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White)
    {
  Crossfade(targetState = Screen.NavigationRouter.currentScreen, label = "") {
      currentState->
      when(currentState.value){
          is Screen.SignUpScreen ->{
              SignUpScreen()
          }
          is Screen.LoginScreen ->{
              LoginScreen()
          }

          else -> {}
      }
  }

    }
}




