package com.example.reto.vista

import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.ui.theme.AppViewModelProvider
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.reto.MainActivity
import com.example.reto.components.CameraButton
import com.example.reto.components.HeaderBar
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun FormScreen42(
    navController: NavController,
    viewModel: Formulario_4_2ViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    //Room
    val coroutineScope = rememberCoroutineScope()
    val valores = viewModel.itemUiState.itemDetails
    val Cambio = viewModel::updateUiState

    var observations by remember { mutableStateOf("") }
    var selectedOption by remember{ mutableStateOf(value = "") }
    var selectedCambio by remember{ mutableStateOf(value = "") }
    var selectedCobertura by remember { mutableStateOf(value = "") }
    var codigo by remember { mutableStateOf(value = "" ) }
    var cropType by remember { mutableStateOf(value = "") }
    var selectedDisturbance by remember { mutableStateOf(value = "") }
    Cambio(valores.copy(Seguimiento = selectedOption, Cambio = selectedCambio, Cobertura = selectedCobertura, Disturbio = selectedDisturbance))
    val option = listOf("Si", "No")
    val cobertura = listOf("BD", "RA", "RB", "PA", "PL", "CP", "CT", "VH", "TD", "IF")
    val disturbance = listOf("Inundación", "Quema", "Tala", "Erosión", "Mineria", "Carretera", "Más plantas acuáticas", "Otro")
    var selectedFileUris by remember { mutableStateOf<List<Uri>>(emptyList()) }

// ActivityResultLauncher para seleccionar múltiples archivos
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenMultipleDocuments()
    ) { uris: List<Uri>? ->
        // Guarda los URIs de los archivos seleccionados
        selectedFileUris = uris ?: emptyList()
        Cambio(valores.copy(Imagenes = selectedFileUris))
    }

    val isFormComplete by derivedStateOf {
        valores.codigo.isNotBlank() &&
                selectedOption.isNotBlank() &&
                selectedCambio.isNotBlank() &&
                selectedCobertura.isNotBlank() &&
                valores.tipoCultivo.isNotBlank() &&
                selectedDisturbance.isNotBlank()
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
                value = valores.codigo,
                onValueChange = { Cambio(valores.copy(codigo = it)) },
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
                            onClick = {
                                selectedOption = option
                                Cambio(valores.copy(Seguimiento = selectedOption))
                            }
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
                                selected = selectedCambio == option,
                                onClick = { selectedCambio = option }
                            )
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically // Alineación vertical
                    ) {
                        RadioButton(
                            selected = selectedCambio == option,
                            onClick = {
                                selectedCambio = option
                                Cambio(valores.copy(Cambio = selectedCambio))
                            }
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
                            onClick = {
                                selectedCobertura = cobertura
                                Cambio(valores.copy(Cobertura = selectedCobertura))
                            }
                        )
                        Text(cobertura)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Número de Individuos
            OutlinedTextField(
                value = valores.tipoCultivo,
                onValueChange = { Cambio(valores.copy(tipoCultivo = it)) },
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
                            onClick = {
                                selectedDisturbance = disturbance
                                Cambio(valores.copy(Disturbio = selectedDisturbance))
                            }
                        )
                        Text(disturbance)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

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
                                            Cambio(valores.copy(Imagenes = selectedFileUris))
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

            // Observaciones
            OutlinedTextField(
                value = valores.observaciones,
                onValueChange = { Cambio(valores.copy(observaciones = it)) },
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
                    onClick = { navController.navigate(route = "SearchScreen")
                        coroutineScope.launch {
                            Cambio(valores.copy(formId = viewModel.getfromID()))
                            viewModel.saveItem()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenAwaqOscuro
                    ),
                    modifier = Modifier
                        .weight(1f) // Ocupa espacio proporcional
                        .padding(start = 8.dp),
                    enabled = isFormComplete // Habilita solo si el formulario está completo
                ) {
                    Text("ENVIAR", color = if (isFormComplete) Color.White else Color.Gray)
                }
            }

        }
    }
}
