import androidx.compose.foundation.Image
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
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun FormScreen() {
    var transectNumber by remember { mutableStateOf("") }
    var commonName by remember { mutableStateOf("") }
    var scientificName by remember { mutableStateOf("") }
    var numberOfIndividuals by remember { mutableStateOf("") }
    var selectedAnimal by remember { mutableStateOf("Insecto") }
    var selectedObservationType by remember { mutableStateOf("La Vió") }
    var observations by remember { mutableStateOf("") }
    val animalTypes = listOf("Mamífero", "Ave", "Reptil", "Anfibio", "Insecto")
    val observationTypes = listOf("La Vió", "Huella", "Rastro", "Cacería", "Le Dijeron")

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
                    IconButton(onClick = { /* Acción al presionar atrás */ }) {
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
            // Número de Transecto
            OutlinedTextField(
                value = transectNumber,
                onValueChange = { transectNumber = it },
                label = { Text("Número de Transecto") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tipo de Animal
            Text("Tipo de Animal", fontSize = 18.sp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                animalTypes.forEach { animal ->
                    IconToggleButton(
                        checked = selectedAnimal == animal,
                        onCheckedChange = { selectedAnimal = animal }
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
                            .padding(0.dp)
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

            // Evidencias (botón para elegir archivo)
            Button(onClick = { /* Acción para elegir archivo */ }) {
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /* Acción Atrás */ }) {
                    Text("ATRÁS")
                }
                Button(onClick = { /* Acción Enviar */ }) {
                    Text("ENVIAR")
                }
            }
        }
    }
}
