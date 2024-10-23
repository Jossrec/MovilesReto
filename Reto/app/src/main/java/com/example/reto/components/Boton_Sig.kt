package com.example.reto.components

import androidx.compose.foundation.ScrollState
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
import com.example.reto.ui.theme.BotonAwaq

@Composable
fun Boton(scrollState: ScrollState){
    Button(
        onClick = { /* Acción del botón */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 100.dp, vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BotonAwaq // Color personalizado
        )
    ) {
        Text(
            text = "Siguiente",
            fontSize = 20.sp,        // Tamaño de fuente
            fontWeight = FontWeight.Bold // Texto grueso
        )
    }
}
