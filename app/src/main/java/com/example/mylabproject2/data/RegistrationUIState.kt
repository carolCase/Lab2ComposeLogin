package com.example.mylabproject2.data


//Users
data class RegistrationUIState(
    var userName:String = "",
    var password : String = "",


    var userNameError : Boolean = false,
    var passwordError : Boolean = false
)
