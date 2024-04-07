package com.example.mylabproject2.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.mylabproject2.R
import com.example.mylabproject2.components.MyTextField


@Composable
fun ForgotPassword() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center)
    {
        Text(text = "Please enter your email to reset password")
     /*   MyTextField(
            labelValue = "enter email",
            painterResource(id = R.drawable.baseline_email_24)
        )*/
    }
    
    
    
    
}
