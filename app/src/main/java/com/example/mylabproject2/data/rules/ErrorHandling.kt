package com.example.mylabproject2.data.rules

object ErrorHandling
{

    fun checkUserName(name:String): HandlingResult{
        return HandlingResult(
            (name.isNotEmpty())
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