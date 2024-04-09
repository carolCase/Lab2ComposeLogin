package com.example.mylabproject2.data



import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mylabproject2.data.rules.ErrorHandling
import com.example.mylabproject2.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener


class SignUpViewModel:ViewModel() {
    var signUpUIState = mutableStateOf(SignUpUIState())

var allErrorHandlingPassed = mutableStateOf(false)


    fun onEvent(event:SignUpUIEvent){
        errorHandlingWithRules()
        when(event){
            is SignUpUIEvent.EmailChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    email = event.email
                )


            }
            is SignUpUIEvent.PasswordChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                   password = event.password
                )

            }
            is SignUpUIEvent.RegisterButton -> {
                signUp()
             }

        }
    }
     private fun errorHandlingWithRules(){
         val emailResult = ErrorHandling.checkEmail(
             email = signUpUIState.value.email
         )
         val passwordResult = ErrorHandling.checkPassword(
             password = signUpUIState.value.password
         )
        signUpUIState.value = signUpUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status

        )
         //this variable checks that input is write and makes the button register
        allErrorHandlingPassed.value =emailResult.status && passwordResult.status
     }
private fun signUp(){
    createUserFirebase(
        email = signUpUIState.value.email,
        password =signUpUIState.value.password )
}

    //this function will register user in firebase
   private fun createUserFirebase(email: String, password : String){
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                 if (it.isSuccessful){
                   Screen.NavigationRouter.navigateTo(Screen.HomeScreen)
                 }
            }
           /* .addOnFailureListener{

            }*/
    }


fun logout(){
    val firebaseAuth = FirebaseAuth.getInstance()
    firebaseAuth.signOut()
    val authStateListener = AuthStateListener{
        if(it.currentUser == null){
           Screen.NavigationRouter.navigateTo(Screen.LoginScreen)
        }
    }
    firebaseAuth.addAuthStateListener(authStateListener)
}

}