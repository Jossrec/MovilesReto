package com.example.reto.vista

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.result.Credentials
import com.auth0.android.callback.Callback

import com.auth0.android.authentication.AuthenticationException
import com.example.reto.R


@Composable
fun AuthApp(auth0: Auth0, onLoginSuccess: (Credentials) -> Unit, onLogout: () -> Unit) {
    var loggedIn by remember { mutableStateOf(false) }
    var credentials by remember { mutableStateOf<Credentials?>(null) }
    if (loggedIn) {
        onLoginSuccess(credentials!!)
    } else {
        onLogout()
    }
}


fun loginWithUsernamePassword(
    auth0: Auth0,
    email: String,
    password: String,
    onSuccess: (Credentials) -> Unit,
    onError: (String) -> Unit
) {
    val authentication = AuthenticationAPIClient(auth0)
    authentication
        .login(email, password, "Username-Password-Authentication")
        .setConnection("Username-Password-Authentication")
        .validateClaims()
        .setScope("openid profile email")
        .start(object : Callback<Credentials, AuthenticationException> {
            override fun onSuccess(result: Credentials) {
                onSuccess(result)
            }

            override fun onFailure(error: AuthenticationException) {
                Log.e("AuthError", "Authentication error: ${error.getDescription()}")
                onError(error.message ?: "Unknown error")
            }
        })
}

@Composable
fun LoginScreen(
    navController: NavController,
    auth0: Auth0,
    onLoginSuccess: (Credentials) -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Bienvenido",
                style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White),
                modifier = Modifier.align(Alignment.TopStart).padding(top = 150.dp, start = 25.dp)
            )

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                Text(
                    text = "Inicia Sesión",
                    style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(bottom = 16.dp, top = 130.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Contraseña") },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )

                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Button(
                    onClick = {
                        loginWithUsernamePassword(auth0, email, password, onLoginSuccess, onError = { message ->
                            errorMessage = message
                        })
                    },
                    modifier = Modifier
                        .width(150.dp)
                        .height(48.dp)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4D752D))
                ) {
                    Text(text = "ENTRAR", fontSize = 16.sp)
                }
            }
        }
    }
}