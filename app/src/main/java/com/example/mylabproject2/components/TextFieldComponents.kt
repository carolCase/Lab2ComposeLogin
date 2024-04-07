package com.example.mylabproject2.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String, painterResource: Painter, onTextSelected: (String)-> Unit) {
    val textValue = remember { mutableStateOf("") }


    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        value = textValue.value,
        colors = OutlinedTextFieldDefaults.colors(
            errorTextColor = Color.Red,
            cursorColor = Color.Black,
            focusedBorderColor = Color.DarkGray,
            focusedLabelColor = Color.LightGray
        ),

        onValueChange = {
            textValue.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        }

    )





}

@Composable
fun PasswordTextField(labelValue: String,painterResource: Painter,onTextSelected: (String) -> Unit
) {
    val password = remember { mutableStateOf("") }
   val passwordVisible = remember {
       mutableStateOf(false)
   }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        value = password.value,
        colors = OutlinedTextFieldDefaults.colors(
            errorTextColor = Color.Red,
            cursorColor = Color.Black,
            focusedBorderColor = Color.DarkGray,
            focusedLabelColor = Color.LightGray
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)  ,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            } else{
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible.value){
                "hide password"
            } else {
                "show password"
            }

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription =description )
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation()

    )
}