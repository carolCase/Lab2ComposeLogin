package com.example.mylabproject2.screens


import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.mylabproject2.navigation.Screen


@Composable
    fun WelcomeScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(45.dp),
    ){
        Button(onClick = { Screen.NavigationRouter.navigateTo(Screen.SignUpScreen)}, modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        )
        {
            Box(modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(colors = listOf(Color.Black, Color.Gray)),
                    shape = RoundedCornerShape(50.dp),

                    ),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = "Enter",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold)
            }
        }
    }
    }




@Preview
@Composable
fun WelcomePreview() {
  WelcomeScreen()
}





