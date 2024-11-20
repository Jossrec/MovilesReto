package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.components.NavegacionInferior
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import com.example.reto.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onLogout: () -> Unit, modifier: Modifier = Modifier, navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                // Fondo con imagen
                Image(
                    painter = painterResource(id = R.drawable.semicirculo_removebg_preview),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )

                // Top App Bar con íconos
                CenterAlignedTopAppBar(
                    modifier = Modifier.height(90.dp),
                    title = {},
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.Black
                    ),
                    navigationIcon = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.size(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.awaq_verde_vertical),
                                contentDescription = "Logo",
                                contentScale = ContentScale.Inside,
                                modifier = Modifier.size(100.dp)
                            )
                        }
                    },
                    actions = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.size(100.dp)
                        ) {
                            IconButton(onClick = { navController.navigate("ProfileScreen") }) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Perfil",
                                    tint = Color.Black,
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                        }
                    },
                    scrollBehavior = scrollBehavior
                )

                // Texto "Hola, Samantha"
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 90.dp), // Ubicar debajo del TopAppBar
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Hola, Samantha",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("Formulario1") },
                modifier = Modifier.size(80.dp),
                containerColor = GreenAwaqOscuro
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Nuevo formulario",
                    modifier = Modifier.size(40.dp),
                    tint = Color.White

                )
            }
        },
        bottomBar = {
            NavegacionInferior(navController)
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(color = White)
            ) {
                DashboardContent(Modifier.padding(top = 32.dp))
            }
        }
    )
}

@Composable
fun DashboardContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tarjeta de notificación
        EmergencyMessageCard()

        Spacer(modifier = Modifier.height(16.dp))

        // Indicador circular de progreso
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(200.dp)
        ) {
            CircularProgressIndicator(
                progress = 0.6f,
                modifier = Modifier.size(200.dp),
                color = Color(0xFF4CAF50), // Verde oscuro
                strokeWidth = 12.dp
            )
            Text(
                text = "60%",
                fontSize = 40.sp,
                color = Color(0xFF4CAF50), // Mismo color del indicador
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Estadísticas de formularios
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Columna "En Total"
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "5 Forms",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "En Total",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            // Columna "Subidos"
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "3 Forms",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4CAF50) // Verde oscuro
                )
                Text(
                    text = "Subidos",
                    fontSize = 16.sp,
                    color = Color(0xFF4CAF50) // Verde oscuro
                )
            }

            // Columna "Guardados"
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "2 Forms",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFD32F2F) // Rojo oscuro
                )
                Text(
                    text = "Guardados",
                    fontSize = 16.sp,
                    color = Color(0xFFD32F2F) // Rojo oscuro
                )
            }
        }
    }
}

@Composable
fun EmergencyMessageCard() {
    // Define los colores
    val backgroundColor = Color(0xFFF8ECED) // Fondo de la tarjeta
    val textColor = Color(0xFFBC4790) // Color de las letras (#BC4790)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor) // Fondo de la tarjeta
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícono de advertencia
            Icon(
                imageVector = Icons.Default.Warning, // Cambiar al ícono correspondiente
                contentDescription = "Icono de notificación",
                tint = textColor,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Texto de la tarjeta
            Column {
                Text(
                    text = "Notificaciones",
                    color = textColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Tienes 2 formularios sin subir a la nube.",
                    color = textColor,
                    fontSize = 14.sp
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(
        onLogout = { /* Acción simulada para cerrar sesión */ },
        navController = navController,
        modifier = Modifier.fillMaxSize()
    )
}
