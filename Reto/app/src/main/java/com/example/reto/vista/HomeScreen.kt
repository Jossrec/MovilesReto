package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.R

@Composable
fun HomeScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // No hace nada por ahora
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Nuevo formulario")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(Color(0xFFF1F8E9)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Sección del encabezado con imagen y el ícono de perfil
                HeaderWithImageAndProfileIcon()

                // Contenido del Dashboard
                DashboardContent(Modifier.padding(top = 32.dp))
            }
        }
    )
}

@Composable
fun HeaderWithImageAndProfileIcon() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.semicirculo_removebg_preview),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        // Texto centrado sobre la imagen
        Text(
            text = "Hola, Samantha",
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.Center)
        )

        // Botón de perfil en la esquina superior derecha
        IconButton(
            onClick = {
                // Acción para abrir el perfil
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(35.dp)
        ) {
            Icon(Icons.Filled.Person, contentDescription = "Perfil", tint = Color.Black)
        }
    }
}

@Composable
fun DashboardContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF1F8E9))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mensaje de emergencia
        EmergencyMessageCard()

        Spacer(modifier = Modifier.height(16.dp))

        // Simulación de una gráfica
        CircularProgressIndicator(
            progress = 0.6f,
            modifier = Modifier.size(100.dp),
            color = Color(0xFF9CCC65)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "60%", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "5 Forms", fontSize = 16.sp)
                Text(text = "En total", fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.width(32.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "3 Forms", fontSize = 16.sp)
                Text(text = "Subidos", fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.width(32.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "2 Forms", fontSize = 16.sp)
                Text(text = "Guardados", fontSize = 14.sp, color = Color.Red)
            }
        }
    }
}

@Composable
fun EmergencyMessageCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Red)
    ) {
        Text(
            text = "¡Emergencia!\nTienes 2 formularios sin subir a la nube.",
            color = Color.White,
            modifier = Modifier.padding(16.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}
