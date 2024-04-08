package com.example.mylabproject2.data


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mylabproject2.data.rules.ErrorHandling
import com.google.firebase.auth.FirebaseAuth


class LoginViewModel:ViewModel() {
    var registrationUIState = mutableStateOf(RegistrationUIState())

var allErrorHandlingPassed = mutableStateOf(false)


    fun onEvent(event:UIEvent){
        ErrorHandlingWithRules()
        when(event){
            is UIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )


            }
            is UIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                   password = event.password
                )

            }
            is UIEvent.RegisterButton -> {
                signUp()
             }

        }
    }
     private fun ErrorHandlingWithRules(){
         val emailResult = ErrorHandling.checkEmail(
             email = registrationUIState.value.email
         )
         val passwordResult = ErrorHandling.checkPassword(
             password = registrationUIState.value.password
         )
        registrationUIState.value = registrationUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status

        )
        allErrorHandlingPassed.value =emailResult.status && passwordResult.status
     }
private fun signUp(){
    createUserFirebase(
        email = registrationUIState.value.email,
        password =registrationUIState.value.password )
}

   private fun createUserFirebase(email: String, password : String){
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{

            }
            .addOnFailureListener{

            }
    }




}