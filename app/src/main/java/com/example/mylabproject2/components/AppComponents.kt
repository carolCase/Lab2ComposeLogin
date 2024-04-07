package com.example.mylabproject2.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.AnnotatedString

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun TextComponent(value:String) {
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),  // heightIn wraps content
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(color = Color.LightGray)
        ),
        color = Color.Black,
        textAlign = TextAlign.Center

    )
}

@Composable
fun HeadingComponent(value:String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth(),  // heightIn wraps content
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(color = Color.LightGray)
        ),
        color = Color.Black,
        textAlign = TextAlign.Center

    )
}


@Composable
fun CheckboxComponent(value: String) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp)
        .padding(16.dp), verticalAlignment = Alignment.CenterVertically,
        ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value, onCheckedChange = { newValue ->
            checkedState.value = newValue
        })
           
        Text(text = value)

    }
}


@Composable
fun ButtonComponent(value:String, onButtonClicked : ()-> Unit) {
    Button(onClick = { onButtonClicked.invoke() }, modifier = Modifier
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
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center
        )
        {
            Text(text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold)
        }
    }
}


@Composable
fun DividerComponent() {
  Row(modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically)
  {
      Divider(modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
      color = Color.Gray,
          thickness = 1.dp
      )

      Text(text = "or register with",
          fontSize = 18.sp,
          modifier = Modifier
              .padding(8.dp))

      Divider(modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
            )
    }
}


@Composable
fun ClickableTextComponent(value: String) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraLight,
                fontStyle = FontStyle.Normal),
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {  }

            )
    }
}



