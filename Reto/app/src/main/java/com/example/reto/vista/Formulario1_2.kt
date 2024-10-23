package com.example.reto.vista

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reto.components.DoubleButton

import com.example.reto.components.HeaderBar

@Composable
fun Formulario1_2(){
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = { HeaderBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            DoubleButton(scrollState)
        }

    }
}

@Composable
fun content(){

}