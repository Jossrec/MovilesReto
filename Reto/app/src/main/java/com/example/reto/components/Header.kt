package com.example.reto.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "Formulario",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = GreenAwaq,
            titleContentColor = Black,
            scrolledContainerColor = GreenAwaq
        ),
        navigationIcon = {
            IconButton(onClick = { /* Acción de navegación */ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Regresar"
                )
            }
        }
    )
}