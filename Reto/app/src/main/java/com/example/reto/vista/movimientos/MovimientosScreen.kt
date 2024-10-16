package com.example.reto.vista.movimientos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign.Companion.Center

@Composable
fun Todos(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            Icons.Outlined.EmojiEmotions,
            "Todos")
        Text(text ="Todos",
            style= MaterialTheme.typography.titleMedium,
            textAlign = Center
        )

    }
}

@Composable
fun Guardados(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(Icons.Outlined.EmojiEmotions,
            "Guardados")
        Text(text ="Guardados",
            style= MaterialTheme.typography.titleMedium,
            textAlign = Center)

    }
}

@Composable
fun Subidos(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(Icons.Outlined.EmojiEmotions,
            "Subidos")
        Text(text ="Subidos",
            style= MaterialTheme.typography.titleMedium,
            textAlign = Center)

    }
}