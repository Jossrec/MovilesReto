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
fun FormScreen3(navController: NavController) {
    var transectNumber by remember { mutableStateOf("") }
    var commonName by remember { mutableStateOf("") }
    var scientificName by remember { mutableStateOf("") }
    var numberOfIndividuals by remember { mutableStateOf("") }
    var selectedAnimal by remember { mutableStateOf("Insecto") }
    var selectedObservationType by remember { mutableStateOf("La Vió") }
    var selectedZone by remember { mutableStateOf("Bosque") }
    var selectedAltitude by remember { mutableStateOf("Baja <1mt") }
    var observations by remember { mutableStateOf("") }
    val animalTypes = listOf("Mamífero", "Ave", "Reptil", "Anfibio", "Insecto")
    val observationTypes = listOf("La Vió", "Huella", "Rastro", "Cacería", "Le Dijeron")
    val zones = listOf("Bosque", "Arreglo Agroforestal", "Cultivos Transitorios", "Cultivos Permanentes")
    val altitudes = listOf("Baja <1mt", "Media 1-3mt", "Alta >3mt")
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
            // Selección de Zona
            Text("Zona", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                zones.forEach { zone -> // Utiliza cada zona para crear un radio button
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedZone == zone,
                                onClick = { selectedZone = zone }
                            )
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically // Alineación vertical
                    ) {
                        RadioButton(
                            selected = selectedZone == zone,
                            onClick = { selectedZone = zone }
                        )
                        Text(zone)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            // Tipo de Animal
            Text("Tipo de Animal", fontSize = 18.sp)
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    animalTypes.take(3).forEach { animal -> // Primeros tres animales en la primera fila
                        Box(
                            modifier = Modifier
                                .padding(4.dp) // Espaciado entre cada elemento
                                .background(
                                    color = if (selectedAnimal == animal) GreenAwaq else Color.Transparent, // Fondo según selección
                                    shape = MaterialTheme.shapes.medium // Borde redondeado
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color.Gray,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable { selectedAnimal = animal } // Cambiar la selección al hacer clic
                                .padding(8.dp) // Espacio dentro de la caja
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = when (animal) {
                                        "Mamífero" -> R.drawable.ic_mammal
                                        "Ave" -> R.drawable.ic_bird
                                        "Reptil" -> R.drawable.ic_reptile
                                        else -> R.drawable.ic_insect
                                    }),
                                    contentDescription = animal,
                                    modifier = Modifier.size(64.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Text(animal)
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    animalTypes.drop(3).forEach { animal -> // Los dos últimos animales en la segunda fila
                        Box(
                            modifier = Modifier
                                .padding(4.dp) // Espaciado entre cada elemento
                                .background(
                                    color = if (selectedAnimal == animal) GreenAwaq else Color.Transparent, // Fondo según selección
                                    shape = MaterialTheme.shapes.medium // Borde redondeado
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color.Gray,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable { selectedAnimal = animal } // Cambiar la selección al hacer clic
                                .padding(8.dp) // Espacio dentro de la caja
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = when (animal) {
                                        "Mamífero" -> R.drawable.ic_mammal
                                        "Ave" -> R.drawable.ic_bird
                                        "Reptil" -> R.drawable.ic_reptile
                                        "Anfibio" -> R.drawable.ic_amphibian
                                        else -> R.drawable.ic_insect
                                    }),
                                    contentDescription = animal,
                                    modifier = Modifier.size(64.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Text(animal)
                            }
                        }
                    }
                }
            }



            Spacer(modifier = Modifier.height(16.dp))

            // Nombre Común
            OutlinedTextField(
                value = commonName,
                onValueChange = { commonName = it },
                label = { Text("Nombre Común") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre Científico
            OutlinedTextField(
                value = scientificName,
                onValueChange = { scientificName = it },
                label = { Text("Nombre Científico (Opcional)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Número de Individuos
            OutlinedTextField(
                value = numberOfIndividuals,
                onValueChange = { numberOfIndividuals = it },
                label = { Text("Número de Individuos") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tipo de Observación
            Text("Tipo de Observación", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                observationTypes.forEach { observation ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedObservationType == observation,
                                onClick = { selectedObservationType = observation }
                            )
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically // Alineación vertical
                    ) {
                        RadioButton(
                            selected = selectedObservationType == observation,
                            onClick = { selectedObservationType = observation }
                        )
                        Text(observation)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Altura de Observación
            Text("Altura de Observación", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                altitudes.forEach { altitude ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedAltitude == altitude,
                                onClick = { selectedAltitude = altitude }
                            )
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically // Alineación vertical
                    ) {
                        RadioButton(
                            selected = selectedAltitude == altitude,
                            onClick = { selectedAltitude = altitude }
                        )
                        Text(altitude)
                    }
                }
            }

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

@Preview(showSystemUi = true)
@Composable
fun showFormScreen3 (modifier: Modifier = Modifier){
    var navController = rememberNavController()
    FormScreen3(navController)
}