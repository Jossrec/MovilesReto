package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.reto.R
import com.example.reto.navigation.NavScreen
import kotlinx.coroutines.delay

@Composable
fun StartScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(2000) // Espera 2 segundos
        navController.navigate(NavScreen.LoginScreen.name) {
            popUpTo(NavScreen.Start.name) { inclusive = true } // Elimina la pantalla de Start del backstack
        }
    }
    Image(
        painter = painterResource(id = R.drawable.awaqintro),
        contentDescription = "Pantalla de introducción",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}
