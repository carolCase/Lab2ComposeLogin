package com.example.mylabproject2.data
//sealed class
open class UIEvent {

    data class EmailChanged(val email:String):UIEvent()
    data class PasswordChanged(val password:String):UIEvent()

      object RegisterButton : UIEvent()

}