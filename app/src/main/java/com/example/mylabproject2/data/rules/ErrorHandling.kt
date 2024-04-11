package com.example.mylabproject2.data.rules

object ErrorHandling
{

    fun checkEmail(email:String): HandlingResult{
        return HandlingResult(
            (email.isNotEmpty())
        )
    } //Toast??

    fun checkPassword(password:String) : HandlingResult{
        return HandlingResult(
            (password.isNotEmpty() && password.length>=6)
        )
           //Toast?? Must have at least six characters
    }



}

data class HandlingResult(val status : Boolean = false){

}