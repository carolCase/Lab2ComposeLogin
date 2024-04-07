package com.example.mylabproject2.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.material.tabs.TabLayout.TabGravity

class LoginViewModel:ViewModel() {
    private var registrationUIState = mutableStateOf(RegistrationUIState())
    private val TAG = LoginViewModel::class.simpleName



    fun onEvent(event:UIEvent){
        when(event){
            is UIEvent.UserNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    userName = event.userName
                )
                printState()
            }
            is UIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                   password = event.password
                )
                printState()
            }

        }
    }

    private fun printState(){
        Log.d(TAG,"Inside_printState")
        Log.d(TAG,registrationUIState.value.toString())
    }


}