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

import androidx.compose.ui.unit.dp
import com.example.mylabproject2.components.ButtonComponent
import com.example.mylabproject2.components.HeadingComponent
import com.example.mylabproject2.data.SignUpViewModel

@Composable
fun HomeScreen(signUpViewModel: SignUpViewModel) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(45.dp),
    )

    {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center) {
            HeadingComponent(value = "About Personal Finance Manager")
            Spacer(modifier = Modifier.height(30.dp))




            ButtonComponent(value = "Logout", onButtonClicked = {
                 signUpViewModel.logout()
            }, isEnabled = true)
        }
    }
}

