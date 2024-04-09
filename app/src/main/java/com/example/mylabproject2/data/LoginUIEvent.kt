package com.example.mylabproject2.data

sealed class LoginUIEvent {

    data class EmailChanged(val email:String):LoginUIEvent()
    data class PasswordChanged(val password:String):LoginUIEvent()


    data object LoginButton : LoginUIEvent()
}