package com.example.reto.vista

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.maps.android.compose.GoogleMap

import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.CameraPosition

import androidx.compose.foundation.layout.*
import com.example.reto.ui.theme.GreenAwaqOscuro
import com.google.android.gms.maps.GoogleMap


@Composable
fun MapScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Mapa o contenido principal
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(LatLng(-33.852, 151.211), 10f)
            }
        )

        // Botón en la parte inferior
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom // Colocar el botón en la parte inferior
        ) {
            Button(
                onClick = { navController.navigate("Formulario1" )},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 100.dp, vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenAwaqOscuro// Color personalizado
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


