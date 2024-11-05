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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun FormScreen5(navController: NavController) {
    var codigo by remember { mutableStateOf("") }
    var nombreComunEspecie by remember { mutableStateOf("") }
    var nombreCientifico by remember { mutableStateOf("") }
    var placa by remember { mutableStateOf("") }
    var circunferencia by remember { mutableStateOf("") }
    var distancia by remember { mutableStateOf("") }
    var estaturaBiomonitor by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var observations by remember { mutableStateOf("") }

    // Variables de estado para las selecciones
    var selectedCuadrante by remember { mutableStateOf("A") }
    var selectedSubCuadrante by remember { mutableStateOf(1) }
    var selectedHabito by remember { mutableStateOf("Arbolito 1-3 mt") }

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
            // Código
            OutlinedTextField(
                value = codigo,
                onValueChange = { codigo = it },
                label = { Text("Código") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Cuadrante
            Text("Cuadrante", fontSize = 18.sp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Cuadrantes A y B
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    listOf("A", "B").forEach { cuadrante ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(80.dp, 100.dp)
                                .background(
                                    color = if (selectedCuadrante == cuadrante) GreenAwaq else Color.Transparent,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color.Gray,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable { selectedCuadrante = cuadrante }
                                .padding(8.dp)
                        ) {
                            Text(
                                text = cuadrante,
                                fontSize = 18.sp,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }

                // Separador
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(40.dp))
                    Text("-", fontSize = 24.sp)
                }

                // Cuadrantes C, D, E, F, G
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    listOf("C", "D", "E", "F", "G").forEach { letra ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(60.dp, 40.dp)
                                .background(
                                    color = if (selectedCuadrante == letra) GreenAwaq else Color.Transparent,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color.Gray,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable { selectedCuadrante = letra }
                                .padding(4.dp)
                        ) {
                            Text(
                                text = letra,
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
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
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(60.dp, 40.dp)
                            .background(
                                color = if (selectedSubCuadrante == numero) GreenAwaq else Color.Transparent,
                                shape = MaterialTheme.shapes.medium
                            )
                            .border(
                                width = 2.dp,
                                color = Color.Gray,
                                shape = MaterialTheme.shapes.medium
                            )
                            .clickable { selectedSubCuadrante = numero }
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "$numero",
                            fontSize = 16.sp,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Hábito de crecimiento
            Text("Hábito de crecimiento", fontSize = 18.sp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf(
                    Pair("Arbusto < 1mt", R.drawable.arbusto),
                    Pair("Arbolito 1-3 mt", R.drawable.arbolito),
                    Pair("Árbol > 3mt", R.drawable.arbol)
                ).forEach { (tipo, imageRes) ->
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(120.dp, 140.dp)
                            .background(
                                color = if (selectedHabito == tipo) GreenAwaq else Color.Transparent,
                                shape = MaterialTheme.shapes.medium
                            )
                            .border(
                                width = 2.dp,
                                color = Color.Gray,
                                shape = MaterialTheme.shapes.medium
                            )
                            .clickable { selectedHabito = tipo }
                            .padding(8.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(id = imageRes),
                                contentDescription = tipo,
                                modifier = Modifier.size(80.dp),
                                contentScale = ContentScale.Fit
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(tipo, fontSize = 14.sp)
                        }
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
                    onClick = { navController.navigate(route = "Formulario1")},
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
                    onClick = { navController.navigate(route = "SearchScreen") },
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


@Composable
fun showFormScreen5(navController: NavController){
    val navController = rememberNavController()
    FormScreen5(navController)
}