package com.example.mylabproject2.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylabproject2.R
import com.example.mylabproject2.components.TextComponent

import com.example.mylabproject2.navigation.Screen


@Composable
    fun WelcomeScreen() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(45.dp),
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.DarkGray)
                .fillMaxSize(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {
            Image(
                painter = painterResource(id = R.drawable.finance),
                contentDescription = "finance",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape),
            )
            Spacer(modifier = Modifier.height(30.dp))
            TextComponent(value = "Personal Finance Manager")

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { Screen.NavigationRouter.navigateTo(Screen.SignUpScreen) },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(48.dp),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(48.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Black,
                                    Color.Gray
                                )
                            ),
                            shape = RoundedCornerShape(50.dp),

                            ),
                    contentAlignment = Alignment.Center
                )
                {
                    Text(
                        text = "Enter",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    }
    }






@Preview
@Composable
fun WelcomePreview() {
  WelcomeScreen()
}





