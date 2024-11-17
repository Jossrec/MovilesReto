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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.ui.theme.AppViewModelProvider
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import com.example.reto.vista.Formulario_1_2ViewModel
import kotlinx.coroutines.launch

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.rememberImagePainter
import com.example.reto.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.*




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    navController: NavController,
    viewModel: Formulario_1_2ViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val valores = viewModel.itemUiState.itemDetails
    val Cambio = viewModel::updateUiState

    var selectedAnimal by remember { mutableStateOf("Insecto") }
    var selectedObservationType by remember { mutableStateOf("La Vió") }
    Cambio(valores.copy(tipoAnimal = selectedAnimal, TipoObservacion = selectedObservationType))

    val animalTypes = listOf("Mamífero", "Ave", "Reptil", "Anfibio", "Insecto")
    val observationTypes = listOf("La Vió", "Huella", "Rastro", "Cacería", "Le Dijeron")

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Formulario",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = Black,
                    scrolledContainerColor = GreenAwaq
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Formulario1")
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            OutlinedTextField(
                value = valores.numeroTransecto,
                onValueChange = { Cambio(valores.copy(numeroTransecto = it)) },
                label = { Text("Número de Transecto") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Tipo de Animal", fontSize = 18.sp)
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    animalTypes.take(3).forEach { animal ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .background(
                                    color = if (selectedAnimal == animal) GreenAwaq else Color.Transparent,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color.Gray,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable {
                                    selectedAnimal = animal
                                    Cambio(valores.copy(tipoAnimal = selectedAnimal))
                                }
                                .padding(8.dp)
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
                    animalTypes.drop(3).forEach { animal ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .background(
                                    color = if (selectedAnimal == animal) GreenAwaq else Color.Transparent,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color.Gray,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable {
                                    selectedAnimal = animal
                                    Cambio(valores.copy(tipoAnimal = selectedAnimal))
                                }
                                .padding(8.dp)
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

            OutlinedTextField(
                value = valores.nombreComun,
                onValueChange = { Cambio(valores.copy(nombreComun = it)) },
                label = { Text("Nombre Común") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.nombreCientifico,
                onValueChange = { Cambio(valores.copy(nombreCientifico = it)) },
                label = { Text("Nombre Científico (Opcional)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.numeroIndividuos,
                onValueChange = { Cambio(valores.copy(numeroIndividuos = it)) },
                label = { Text("Número de Individuos") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Tipo de Observación", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                observationTypes.forEach { observation ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedObservationType == observation,
                                onClick = {
                                    selectedObservationType = observation
                                    Cambio(valores.copy(TipoObservacion = selectedObservationType))
                                }
                            )
                            .padding(0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedObservationType == observation,
                            onClick = {
                                selectedObservationType = observation
                                Cambio(valores.copy(TipoObservacion = selectedObservationType))
                            }
                        )
                        Text(observation)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.observaciones,
                onValueChange = { Cambio(valores.copy(observaciones = it)) },
                label = { Text("Observaciones") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigate(route = "Formulario1") },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Text("ATRÁS", color = Color.White)
                }
                Button(
                    onClick = {
                        navController.navigate(route = "HomeScreen")
                        coroutineScope.launch {
                            Cambio(valores.copy(formId = viewModel.getfromID()))
                            viewModel.saveItem()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    Text("ENVIAR", color = Color.White)
                }
            }
        }
    }
}