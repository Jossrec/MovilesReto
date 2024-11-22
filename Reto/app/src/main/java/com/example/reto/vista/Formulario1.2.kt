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

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.ui.theme.AppViewModelProvider

import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import com.example.reto.vista.Formulario_1_2ViewModel
import kotlinx.coroutines.launch
import android.content.Context
import android.content.pm.PackageManager

import android.net.Uri
import android.os.Build

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.example.reto.MainActivity
import com.example.reto.R
import com.example.reto.components.CameraButton
import com.example.reto.components.HeaderBar
import com.example.reto.vista.FormScreen2


@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    navController: NavController,
    viewModel: Formulario_1_2ViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val valores = viewModel.itemUiState.itemDetails
    val Cambio = viewModel::updateUiState

    var selectedAnimal by remember { mutableStateOf("") }
    var selectedObservationType by remember { mutableStateOf("") }
    Cambio(valores.copy(tipoAnimal = selectedAnimal, TipoObservacion = selectedObservationType))


    val animalTypes = remember { listOf("Mamífero", "Ave", "Reptil", "Anfibio", "Insecto") }
    val observationTypes = remember { listOf("La Vió", "Huella", "Rastro", "Cacería", "Le Dijeron") }


    // Lista de URIs seleccionados
    var selectedFileUris by remember { mutableStateOf<List<Uri>>(emptyList()) }

// ActivityResultLauncher para seleccionar múltiples archivos
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenMultipleDocuments()
    ) { uris: List<Uri>? ->
        // Guarda los URIs de los archivos seleccionados
        selectedFileUris = uris ?: emptyList()
    }

    val isFormComplete by derivedStateOf {
        valores.numeroTransecto.isNotBlank() &&
                selectedAnimal.isNotBlank() &&
                valores.nombreComun.isNotBlank() &&
                valores.numeroIndividuos.isNotBlank() &&
                selectedObservationType.isNotBlank()
    }

    Scaffold(
        topBar = { HeaderBar(navController) },
        floatingActionButton = {
            CameraButton(activity = LocalContext.current as MainActivity, navController)
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


//CHECAR CAMBIOS
// Evidencias (botón para elegir archivo)
            Text("Evidencias", fontSize = 18.sp)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                // Botón para abrir el selector de archivos
                Button(
                    onClick = {
                        filePickerLauncher.launch(arrayOf("image/*")) // Filtro para imágenes
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp) // Espacio debajo del botón
                ) {
                    Text("Elige archivos", color = Color.White)
                }

                // Contenedor de vistas previas (aparece solo si hay imágenes seleccionadas)
                if (selectedFileUris.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp) // Altura fija
                            .background(Color.LightGray, shape = MaterialTheme.shapes.small)
                            .padding(8.dp)
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(selectedFileUris.size) { index ->
                                val uri = selectedFileUris[index]
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    // Vista previa de la imagen
                                    Image(
                                        painter = rememberAsyncImagePainter(model = uri),
                                        contentDescription = "Vista previa de la imagen",
                                        modifier = Modifier
                                            .size(64.dp) // Tamaño de la vista previa
                                    )

                                    // Nombre de la imagen
                                    Text(
                                        text = uri.lastPathSegment ?: "Archivo desconocido",
                                        color = Color.Black,
                                        maxLines = 1,
                                        fontSize = 12.sp,
                                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .weight(1f) // Ocupa el espacio restante
                                    )

                                    // Botón para eliminar la imagen
                                    IconButton(
                                        onClick = {
                                            // Elimina la imagen de la lista
                                            selectedFileUris = selectedFileUris.toMutableList().apply {
                                                removeAt(index)
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Eliminar imagen",
                                            tint = Color(0xFFBA2D2D) // Cambia este color a tu preferencia
                                        )
                                    }
                                }
                            }
                        }
                    }
                } else {

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
                        .padding(start = 8.dp),
                    enabled = isFormComplete
                ) {
                    Text("ENVIAR", color = if (isFormComplete) Color.White else Color.Gray)
                }
            }
        }
    }
}


