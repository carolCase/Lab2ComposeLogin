package com.example.mylabproject2.data



data class SignUpUIState(
    var email:String = "",
    var password : String = "",


    var emailError : Boolean = false,
    var passwordError : Boolean = false,

)
