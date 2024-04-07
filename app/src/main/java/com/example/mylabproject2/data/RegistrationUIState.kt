package com.example.mylabproject2.data


//Users
data class RegistrationUIState(
    var email:String = "",
    var password : String = "",


    var emailError : Boolean = false,
    var passwordError : Boolean = false
)
