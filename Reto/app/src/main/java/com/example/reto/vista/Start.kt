package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.reto.R

@Composable
fun StartScreen() {
    Image(
        painter = painterResource(id = R.drawable.awaqintro),
        contentDescription = "Pantalla de introducción",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Fit
    )
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun PreviewStartScreen() {
    StartScreen()
}
