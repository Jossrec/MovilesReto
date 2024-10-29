package com.example.reto.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.example.reto.ui.theme.GreenAwaqOscuro

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
@Composable
fun DoubleButton(scrollState: ScrollState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween // Espacio entre las columnas
    ) {
        // Columna para el primer botón
        Column(
            modifier = Modifier.weight(1f), // Ocupa el 50% del espacio
            horizontalAlignment = Alignment.CenterHorizontally // Alinear el contenido al centro
        ) {
            Button(
                onClick = { /* Acción del botón "Atrás" */ },
                modifier = Modifier
                    .fillMaxWidth() // Llenar el ancho disponible
                    .padding(8.dp), // Padding ajustado
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenAwaqOscuro // Color personalizado
                )
            ) {
                Text(
                    text = "Atrás",
                    fontSize = 20.sp,        // Tamaño de fuente
                    fontWeight = FontWeight.Bold // Texto en negrita
                )
            }
        }

        // Columna para el segundo botón
        Column(
            modifier = Modifier.weight(1f), // Ocupa el 50% del espacio
            horizontalAlignment = Alignment.CenterHorizontally // Alinear el contenido al centro
        ) {
            Button(
                onClick = { /* Acción del botón "Enviar" */ },
                modifier = Modifier
                    .fillMaxWidth() // Llenar el ancho disponible
                    .padding(8.dp), // Padding ajustado
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenAwaqOscuro // Color personalizado
                )
            ) {
                Text(
                    text = "Enviar", // Cambiar a "Enviar"
                    fontSize = 20.sp,        // Tamaño de fuente
                    fontWeight = FontWeight.Bold // Texto en negrita
                )
            }
        }
    }
}
