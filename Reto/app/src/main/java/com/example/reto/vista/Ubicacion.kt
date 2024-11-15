package com.example.reto.vista

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

@Composable
fun MapScreen(navController: NavController) {
    // ScrollState que recuerda la última posición de desplazamiento
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState) // Se aplica el scrollState al mapa
    ) {
        HeaderMap(navController) // Llamado al encabezado

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            // GoogleMap con posición de cámara inicial
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(LatLng(-33.852, 151.211), 10f)
            }
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            )

            // Botón en la parte inferior
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { /* Acción del botón */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 100.dp, vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenAwaqOscuro // Color personalizado
                    )
                ) {
                    Text(
                        text = "Guardar",
                        fontSize = 20.sp,        // Tamaño de fuente
                        fontWeight = FontWeight.Bold // Texto grueso
                    )
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HeaderMap(navController: NavController) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "Mi ubicación",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = GreenAwaq,
            titleContentColor = Color.Black,
            scrolledContainerColor = GreenAwaq
        ),
        navigationIcon = {
            IconButton(onClick = { navController.navigate("Formulario1") }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Regresar"
                )
            }
        }
    )
}
