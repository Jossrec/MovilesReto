package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.R
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            // Envolvemos la TopAppBar en un Box para poder agregar el fondo del semicírculo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Ajusta la altura del TopBar con el semicírculo
                    .background(Color(0xFFF1F8E9))
            ) {
                // Imagen de fondo (el semicírculo)
                Image(
                    painter = painterResource(id = R.drawable.semicirculo_removebg_preview), // Reemplaza con tu semicírculo
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter) // Alinea la imagen en la parte superior
                        .background(Color(0xFFF1F8E9))
                )

                // Contenido de la TopAppBar
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            "Inicio",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Black // El texto ahora es blanco para mejor contraste
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent, // Hacemos transparente la barra para que solo se vea el fondo
                        titleContentColor = Color.Black // Color del título blanco para que contraste con el fondo
                    ),
                    navigationIcon = {
                        // Logo en lugar del ícono de navegación
                        Image(
                            painter = painterResource(id = R.drawable.awaq_verde_vertical), // Reemplaza con tu logo
                            contentDescription = "Logo",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(40.dp) // Ajusta el tamaño del logo
                        )
                    },
                    actions = {
                        // Icono de perfil a la derecha
                        IconButton(onClick = { /* Acción del perfil */ }) {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Perfil",
                                tint = Color.Black // Ícono blanco para mejor contraste
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Aquí iría la navegación para agregar un nuevo formulario
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Nuevo formulario")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(Color(0xFFF1F8E9))
            ) {

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
            .padding(0.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.semicirculo_removebg_preview),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Hola, Samantha",
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.Center)
        )

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
        EmergencyMessageCard()

        Spacer(modifier = Modifier.height(16.dp))

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
    val cardColor = Color.Red

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
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
fun HomeScreenPreview() {
    HomeScreen()
}
