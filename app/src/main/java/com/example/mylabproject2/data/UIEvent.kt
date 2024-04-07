package com.example.mylabproject2.data
//sealed class
open class UIEvent {

    data class UserNameChanged(val userName:String):UIEvent()
    data class PasswordChanged(val password:String):UIEvent()

      object RegisterButton : UIEvent()

}