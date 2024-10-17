package com.example.reto.Vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.reto.R

@Composable
fun LoginScreen() {
    // Variables para los campos de texto
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.fondo1), // Reemplaza con tu imagen
            contentDescription = null,
            contentScale = ContentScale.Crop,  // Ajusta la imagen para que ocupe todo el espacio sin deformarse
            modifier = Modifier.fillMaxSize()
        )

        // Caja de contenido sobre la imagen
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Título "Bienvenido" en la parte superior
            Text(
                text = "Bienvenido",
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 150.dp)
                    .padding(start = 25.dp)
            )

            // Contenedor para los campos de entrada
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center) // Alinear el contenido de la columna al centro
            ) {
                // Título de sesión
                Text(
                    text = "Inicia Sesión",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .padding(top=130.dp)
                )

                // Email Input
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                // Contraseña Input
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Contraseña") },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                // "Olvidaste tu contraseña?" Text
                Text(
                    text = "¿Olvidaste la contraseña?",
                    fontSize = 14.sp,
                    color = Color(0xFF749444),
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(bottom = 32.dp)
                )

                // Botón de Entrar
                Button(
                    onClick = { /* Acción no funcional */ },
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


@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}

