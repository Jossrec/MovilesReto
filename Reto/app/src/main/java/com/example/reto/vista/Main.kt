package com.example.reto.vista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.reto.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Aquí iría la navegación para agregar un nuevo formulario
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Nuevo formulario")
            }
        },
        bottomBar = {
            BottomNavigationBar()
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(Color(0xFFF1F8E9))
            ) {
                HeaderWithImageAndProfileIcon()
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
            .height(250.dp) // Ajusta la altura según sea necesario
            .padding(0.dp) // Remueve cualquier padding extra
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        // Imagen con forma de semicírculo
        Image(
            painter = painterResource(id = R.drawable.semicirculo_removebg_preview), // Reemplaza con tu recurso
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp) // Remueve cualquier padding de la imagen
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
                .align(Alignment.TopEnd) // Alinea en la esquina superior derecha
                .padding(35.dp) // Ajusta el padding para separar el botón del borde
        ) {
            Icon(Icons.Filled.Person, contentDescription = "Perfil", tint = Color.Black)
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFF9CCC65)
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Inicio") },
            selected = true,  // Esto cambia según la pestaña seleccionada
            onClick = {
                // Aquí puedes manejar la navegación
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Buscar") },
            selected = false,
            onClick = {
                // Aquí puedes manejar la navegación a la búsqueda
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Configuración") },
            selected = false,
            onClick = {
                // Aquí puedes manejar la navegación a la configuración
            }
        )
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
        // Popup rojo para el mensaje de emergencia
        EmergencyMessageCard()

        Spacer(modifier = Modifier.height(16.dp))

        // Simulación de una gráfica
        CircularProgressIndicator(
            progress = 0.6f, // Esto se ajustaría con los datos reales
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
    // Aquí definimos el color del card
    val cardColor = Color.Red

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Elevación del Card
        colors = CardDefaults.cardColors(containerColor = cardColor) // Color del fondo del Card
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



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
