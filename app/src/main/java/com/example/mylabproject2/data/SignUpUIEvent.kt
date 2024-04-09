package com.example.mylabproject2.data
//sealed class
sealed class SignUpUIEvent {

    data class EmailChanged(val email:String):SignUpUIEvent()
    data class PasswordChanged(val password:String):SignUpUIEvent()


    data object RegisterButton : SignUpUIEvent()

}