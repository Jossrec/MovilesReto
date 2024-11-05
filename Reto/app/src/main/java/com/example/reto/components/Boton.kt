package com.example.reto.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reto.ui.theme.AppViewModelProvider
import com.example.reto.ui.theme.GreenAwaqOscuro
import com.example.reto.vista.Forms_7_2ViewModel
import com.example.reto.vista.Formulario_1ViewModel
import kotlinx.coroutines.launch

@Composable
fun Boton(
    scrollState: ScrollState,
    viewModel: Formulario_1ViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    val coroutineScope = rememberCoroutineScope()

    Button(
        onClick = {
            coroutineScope.launch {
                viewModel.saveItem()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 100.dp, vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenAwaqOscuro// Color personalizado
        )
    ) {
        Text(
            text = "Siguiente",
            fontSize = 20.sp,        // Tamaño de fuente
            fontWeight = FontWeight.Bold // Texto grueso
        )
    }
}
