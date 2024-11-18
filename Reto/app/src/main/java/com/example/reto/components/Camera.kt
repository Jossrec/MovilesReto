package com.example.reto.components


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset

import androidx.compose.foundation.layout.size

import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.PhotoCamera

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.reto.MainActivity

import com.example.reto.camara.CameraView
import com.example.reto.ui.theme.GreenAwaqOscuro
import com.example.reto.ui.theme.White

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun CameraButton(activity: MainActivity, navController: NavController) {
    var showCamera by remember { mutableStateOf(false) } // Usamos 'by' para simplificar la asignación

    FloatingActionButton(
        onClick = { showCamera = !showCamera }, // Modificamos el estado correctamente
        containerColor = GreenAwaqOscuro,
        contentColor = White,
        modifier = Modifier.offset(y = -80.dp) // Ajustamos la posición vertical
            .size(50.dp) // Tamaño del botón
    ) {
        Icon(
            imageVector = Icons.Filled.PhotoCamera, // Icono de la cámara
            contentDescription = "Abrir cámara"
        )
    }

    // Mostrar la vista de la cámara si el estado está activado
    if (showCamera) {
        CameraView(
            modifier = Modifier.fillMaxSize(),
            activity = activity,
            onClose = { showCamera = false } // Aquí ya no es necesario .value ya que usamos 'by'
        )
    }
}
