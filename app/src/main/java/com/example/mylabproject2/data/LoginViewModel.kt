package com.example.mylabproject2.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mylabproject2.data.rules.ErrorHandling
import com.example.mylabproject2.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel() {


    var loginUIState = mutableStateOf(LoginUIState())
    var allErrorHandlingPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)

    fun onEvent(event:LoginUIEvent){
        when(event){
            is LoginUIEvent.EmailChanged ->{
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }

            is LoginUIEvent.PasswordChanged->{
              loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }

            is LoginUIEvent.LoginButton->{
                login()
            }
        }
        errorHandlingWithRules()
    }

    private fun login() {
        val email = loginUIState.value.email
        val password = loginUIState.value.password
       FirebaseAuth
           .getInstance()
           .signInWithEmailAndPassword(email,password)
           .addOnCompleteListener{
               if(it.isSuccessful){
                  Screen.NavigationRouter.navigateTo(Screen.HomeScreen)
               }
           }
          /* .addOnFailureListener(){

           }*/

    }




    private fun errorHandlingWithRules(){
        val emailResult = ErrorHandling.checkEmail(
            email = loginUIState.value.email
        )
        val passwordResult = ErrorHandling.checkPassword(
            password = loginUIState.value.password
        )
        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status

        )
        //this variable checks that input is write and makes the button Login
        allErrorHandlingPassed.value =emailResult.status && passwordResult.status
    }

}