package com.example.mylabproject2.data.rules

object ErrorHandling
{

    fun checkEmail(email:String): HandlingResult{
        return HandlingResult(
            (email.isNotEmpty())
        )
    }

    fun checkPassword(password:String) : HandlingResult{
        return HandlingResult(
            (password.isNotEmpty() && password.length>=8)
        )

    }



}

data class HandlingResult(val status : Boolean = false){

}