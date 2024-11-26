package com.example.reto.vista

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.Black
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.example.reto.components.NavegacionInferior

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("ProfileScreen") }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Black
                        )
                    }
                },
                title = {
                    Text(
                        "Información",
                        maxLines = 1,
                        color = Black,
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq
                )
            )
        },
    bottomBar = {
        NavegacionInferior(navController)
    }

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp), // Espaciado alrededor del contenido
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Título destacado
            Text(
                text = "¡Hola, somos TechAllies!",
                fontSize = 24.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                color = Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp) // Espacio debajo del título
            )

            // Cuerpo del texto
            Text(
                text = "En la actualidad, el uso de smartphones y aplicaciones móviles ha permitido agilizar una gran cantidad de operaciones. A través de una app segura, las empresas y los usuarios pueden beneficiarse mutuamente con servicios de autoservicio y entrega a domicilio.\n\nNuestro enfoque no solo es técnico, sino también humano, ya que nuestro objetivo está alineado con el Objetivo de Desarrollo Sostenible 9 de la ONU, que busca construir infraestructuras resilientes y sostenibles.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Black,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(bottom = 24.dp) // Espacio debajo del párrafo
            )

            // Información de contacto
            Text(
                text = "¿Tienes dudas? Contáctanos: techallies@tec.mx",
                fontSize = 16.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                color = Black,
                textAlign = TextAlign.Center
            )
        }
    }
}
