package com.example.mylabproject2.data


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mylabproject2.data.rules.ErrorHandling


class LoginViewModel:ViewModel() {
    var registrationUIState = mutableStateOf(RegistrationUIState())




    fun onEvent(event:UIEvent){
        ErrorHandlingWithRules()
        when(event){
            is UIEvent.UserNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    userName = event.userName
                )


            }
            is UIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                   password = event.password
                )

            }
            is UIEvent.RegisterButton -> {
             }
        }
    }
     private fun ErrorHandlingWithRules(){
         val userNameResult = ErrorHandling.checkUserName(
             name = registrationUIState.value.userName
         )
         val passwordResult = ErrorHandling.checkPassword(
             password = registrationUIState.value.password
         )
        registrationUIState.value = registrationUIState.value.copy(
            userNameError = userNameResult.status,
            passwordError = passwordResult.status

        )
     }






}