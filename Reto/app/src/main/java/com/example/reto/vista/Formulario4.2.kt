package com.example.reto.vista

import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun FormScreen42(navController: NavController) {

    var observations by remember { mutableStateOf("") }
    var selectedOption by remember{ mutableStateOf(value = "Si") }
    var selectedCobertura by remember { mutableStateOf(value = "BD") }
    var codigo by remember { mutableStateOf(value = "" ) }
    var cropType by remember { mutableStateOf(value = "") }
    var selectedDisturbance by remember { mutableStateOf(value = "Inundación") }
    val option = listOf("Si", "No")
    val cobertura = listOf("BD", "RA", "RB", "PA", "PL", "CP", "CT", "VH", "TD", "IF")
    val disturbance = listOf("Inundación", "Quema", "Tala", "Erosión", "Mineria", "Carretera", "Más plantas acuáticas", "Otro")
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
                    scrolledContainerColor = GreenAwaq // Mantén el color durante el scroll
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(route = "Formulario1") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                },

                scrollBehavior = scrollBehavior
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
            OutlinedTextField(
                value = codigo,
                onValueChange = { codigo = it },
                label = { Text("Código") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Selección de Zona
            Text("Seguimiento", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                option.forEach { option -> // Utiliza cada zona para crear un radio button
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedOption == option,
                                onClick = { selectedOption = option }
                            )
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically // Alineación vertical
                    ) {
                        RadioButton(
                            selected = selectedOption == option,
                            onClick = { selectedOption = option }
                        )
                        Text(option)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Selección de Zona
            Text("Cambio", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                option.forEach { option -> // Utiliza cada zona para crear un radio button
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedOption == option,
                                onClick = { selectedOption = option }
                            )
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically // Alineación vertical
                    ) {
                        RadioButton(
                            selected = selectedOption == option,
                            onClick = { selectedOption = option }
                        )
                        Text(option)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Selección de Zona
            Text("Cobertura", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                cobertura.forEach { cobertura -> // Utiliza cada zona para crear un radio button
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedCobertura == cobertura,
                                onClick = { selectedCobertura = cobertura }
                            )
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically // Alineación vertical
                    ) {
                        RadioButton(
                            selected = selectedCobertura == cobertura,
                            onClick = { selectedCobertura = cobertura }
                        )
                        Text(cobertura)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Número de Individuos
            OutlinedTextField(
                value = cropType,
                onValueChange = { cropType = it },
                label = { Text("Tipos de cultivos") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Selección de Zona
            Text("Disturbio", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                disturbance.forEach { disturbance -> // Utiliza cada zona para crear un radio button
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedDisturbance == disturbance,
                                onClick = { selectedDisturbance = disturbance }
                            )
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically // Alineación vertical
                    ) {
                        RadioButton(
                            selected = selectedDisturbance == disturbance,
                            onClick = { selectedDisturbance = disturbance }
                        )
                        Text(disturbance)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Evidencias (botón para elegir archivos
            Text("Evidencias", fontSize = 18.sp)
            Button(
                onClick = { /* Acción para elegir archivo */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenAwaq
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

            // Botones Atrás y Enviar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigate(route = "Formulario1") },
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
                    onClick = { navController.navigate(route = "HomeScreen") },
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
@Preview( )
@Composable
fun showform42 (modifier: Modifier = Modifier){
    val navController = rememberNavController()
    FormScreen42(navController )
}