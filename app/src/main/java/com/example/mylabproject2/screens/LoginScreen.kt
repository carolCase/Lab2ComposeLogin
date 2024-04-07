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
import androidx.navigation.NavController
import com.example.mylabproject2.R
import com.example.mylabproject2.components.ButtonComponent
import com.example.mylabproject2.components.ClickableTextComponent
import com.example.mylabproject2.components.HeadingComponent
import com.example.mylabproject2.components.MyTextField
import com.example.mylabproject2.components.PasswordTextField
import com.example.mylabproject2.components.TextComponent

@Composable
fun LoginScreen() {
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

                } )
            PasswordTextField(labelValue = "Enter Password",
                painterResource(id = R.drawable.baseline_password_24), onTextSelected = {

                })
            Spacer(modifier = Modifier.height(30.dp))
            ClickableTextComponent(value = "Forgot Password")
            Spacer(modifier = Modifier.height(25.dp))
            ButtonComponent(value = "Login")


        }

    }




}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}