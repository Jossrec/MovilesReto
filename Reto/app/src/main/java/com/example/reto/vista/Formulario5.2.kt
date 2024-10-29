package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.R
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun FormScreen5() {
    var codigo by remember { mutableStateOf("") }
    var nombreComunEspecie by remember { mutableStateOf("") }
    var nombreCientifico by remember { mutableStateOf("") }
    var placa by remember { mutableStateOf("") }
    var circunferencia by remember { mutableStateOf("") }
    var distancia by remember { mutableStateOf("") }
    var estaturaBiomonitor by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var observations by remember { mutableStateOf("") }

    // Scroll state para la pantalla
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Formulario", maxLines = 1) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = Black,
                    scrolledContainerColor = GreenAwaq
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            // Código
            OutlinedTextField(
                value = codigo,
                onValueChange = { codigo = it },
                label = { Text("Código") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Cuadrante y Sub-Cuadrante
            Text("Cuadrante", fontSize = 18.sp)
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Cuadrante A y B
                Column {
                    Text("A")
                    Text("B")
                }
                // Cuadrante C, D, E, F, G
                Column {
                    listOf("C", "D", "E", "F", "G").forEach { letra ->
                        Text(letra)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sub-Cuadrante
            Text("Sub-Cuadrante", fontSize = 18.sp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                (1..4).forEach { numero ->
                    Text("$numero")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Hábito de crecimiento
            Text("Hábito de crecimiento", fontSize = 18.sp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf("Arbusto < 1mt", "Arbolito 1-3 mt", "Árbol > 3mt").forEach { tipo ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // Aquí debes reemplazar con las imágenes correctas de tu proyecto
//                        Image(
//                            painter = painterResource(id = R.drawable.ic_plant),
//                            contentDescription = null,
//                            modifier = Modifier.size(64.dp)
//                        )
                        Text(tipo)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre Común Especie
            OutlinedTextField(
                value = nombreComunEspecie,
                onValueChange = { nombreComunEspecie = it },
                label = { Text("Nombre Común Especie") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre Científico
            OutlinedTextField(
                value = nombreCientifico,
                onValueChange = { nombreCientifico = it },
                label = { Text("Nombre Científico") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Placa
            OutlinedTextField(
                value = placa,
                onValueChange = { placa = it },
                label = { Text("Placa") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Circunferencia en cm (CL)
            OutlinedTextField(
                value = circunferencia,
                onValueChange = { circunferencia = it },
                label = { Text("Circunferencia en cm (CL)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Distancia en mt
            OutlinedTextField(
                value = distancia,
                onValueChange = { distancia = it },
                label = { Text("Distancia en mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Estatura Biomonitor en mt
            OutlinedTextField(
                value = estaturaBiomonitor,
                onValueChange = { estaturaBiomonitor = it },
                label = { Text("Estatura Biomonitor en mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Altura en mt
            OutlinedTextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text("Altura en mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))


            // Evidencias (botón para elegir archivos
            Text("Evidencias", fontSize = 18.sp)
            Button(
                onClick = { /* Acción para elegir archivo */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenAwaqOscuro
                )
            ) {
                Text("Elige archivo")
            }


            Spacer(modifier = Modifier.height(16.dp))

            // Observaciones
            OutlinedTextField(
                value = observations,
                onValueChange = { observations = it },
                label = { Text("Observaciones") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))


            Spacer(modifier = Modifier.height(16.dp))

            // Botones Atrás y Enviar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Acción Atrás */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenAwaqOscuro
                    ),
                    modifier = Modifier
                        .weight(1f) // Ocupa espacio proporcional
                        .padding(end = 8.dp) // Espaciado entre botones
                ) {
                    Text(
                        "ATRÁS",
                        color = Color.White
                    )
                }
                Button(
                    onClick = { /* Acción Enviar */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenAwaqOscuro
                    ),
                    modifier = Modifier
                        .weight(1f) // Ocupa espacio proporcional
                        .padding(start = 8.dp) // Espaciado entre botones
                ) {
                    Text(
                        "ENVIAR",
                        color = Color.White
                    )
                }
            }

        }
    }
}
