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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.reto.ui.theme.GreenAwaqOscuro

@Composable
fun Boton(scrollState: ScrollState, navController: NavHostController, tipoRegistro: String){
    Button(
        onClick = {
            if (tipoRegistro.isNotEmpty()) {
                navController.navigate(tipoRegistro)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 100.dp, vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenAwaqOscuro// Color personalizado
        ),
        enabled = tipoRegistro.isNotEmpty()
    ) {
        Text(
            text = "Siguiente",
            fontSize = 20.sp,        // Tamaño de fuente
            fontWeight = FontWeight.Bold // Texto grueso
        )
    }
}
