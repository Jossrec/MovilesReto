package com.example.reto.vista

import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.reto.MainActivity
import com.example.reto.R
import com.example.reto.components.CameraButton
import com.example.reto.components.HeaderBar
import com.example.reto.ui.theme.AppViewModelProvider
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen6(
    navController: NavController,
    viewModel: Forms_6_2ViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val valores = viewModel.itemUiState.itemDetails
    val Cambio = viewModel::updateUiState

    var observations by remember { mutableStateOf("") }
    var selectedZona by remember { mutableStateOf(value = "") }
    var codigo by remember { mutableStateOf(value = "") }
    var nomcamara by remember { mutableStateOf(value = "") }
    var placacamara by remember { mutableStateOf(value = "") }
    var placaguaya by remember { mutableStateOf(value = "") }
    var anchocamino by remember { mutableStateOf(value = "") }
    var fechainstalacion by remember { mutableStateOf(value = "") }
    var distobjetivo by remember { mutableStateOf(value = "") }
    var altlente by remember { mutableStateOf(value = "") }
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }

    val zona = listOf("Bosque", "Arreglo Agroforestal", "Cultivos Transitorios", "Cultivos Permanentes")
    // Crear una lista de elementos con su estado de checked mutable
    val items = remember { mutableStateListOf(
        "Programada" to false,
        "Memoria" to false,
        "Prueba de gateo" to false,
        "Instalada" to false,
        "Letrero de cámara" to false,
        "Prendida" to false
    )}

    var selectedFileUris by remember { mutableStateOf<List<Uri>>(emptyList()) }

// ActivityResultLauncher para seleccionar múltiples archivos
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenMultipleDocuments()
    ) { uris: List<Uri>? ->
        // Guarda los URIs de los archivos seleccionados
        selectedFileUris = uris ?: emptyList()
    }

    val isFormComplete by derivedStateOf {
        valores.codigo.isNotBlank() &&
                valores.nombreCamara.isNotBlank() &&
                valores.placaCamara.isNotBlank() &&
                valores.placaGuaya.isNotBlank() &&
                valores.anchoCamino.isNotBlank() &&
                valores.fechaInstalacion.isNotBlank() &&
                valores.distanciaObjetivo.isNotBlank() &&
                valores.alturaLente.isNotBlank()
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
            Text("Zona", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                zona.forEach { zona ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedZona == zona,
                                onClick = { selectedZona = zona }
                            )
                            .height(30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedZona == zona,
                            onClick = { selectedZona = zona
                                Cambio(valores.copy(zona = selectedZona))
                            }
                        )
                        Text(zona)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.nombreCamara,
                onValueChange = {  Cambio(valores.copy(nombreCamara = it)) },
                label = { Text("Nombre Cámara") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.placaCamara,
                onValueChange = {  Cambio(valores.copy(placaCamara = it)) },
                label = { Text("Placa Cámara") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.placaGuaya,
                onValueChange = {  Cambio(valores.copy(placaGuaya = it)) },
                label = { Text("Placa Guaya") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.anchoCamino,
                onValueChange = {  Cambio(valores.copy(anchoCamino = it)) },
                label = { Text("Ancho Camino mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.fechaInstalacion,
                onValueChange = {  Cambio(valores.copy(fechaInstalacion = it))},
                label = { Text("Fecha de Instalación") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.distanciaObjetivo,
                onValueChange = {  Cambio(valores.copy(distanciaObjetivo = it)) },
                label = { Text("Distancia al objetivo mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = valores.alturaLente,
                onValueChange = {  Cambio(valores.copy(alturaLente = it)) },
                label = { Text("Altura del lente mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de chequeo (Checkboxes)
            Text("Lista de chequeo", fontSize = 18.sp)
            Column(modifier = Modifier.selectableGroup()) {
                items.forEachIndexed { index, (label, isChecked) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 0.dp)
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { checked ->
                                items[index] = label to checked // Actualiza el estado del checkbox
                                val nuevoEstado = when (label) {
                                    "Programada" -> valores.copy(programada = isChecked)
                                    "Memoria" -> valores.copy(memoria = isChecked)
                                    "Prueba de gateo" -> valores.copy(pruebaDeGateo = isChecked)
                                    "Instalada" -> valores.copy(instalada = isChecked)
                                    "Letrero de cámara" -> valores.copy(letreroDeCamara = isChecked)
                                    "Prendida" -> valores.copy(prendida = isChecked)
                                    else -> valores // Si no coincide, dejamos el objeto como está
                                }
                                Cambio(nuevoEstado)
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = GreenAwaq,
                                uncheckedColor = Color.Gray
                            )
                        )
                        Text(text = label)
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
                        } },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenAwaqOscuro
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    enabled = isFormComplete // Habilita solo si el formulario está completo
                ) {
                    Text("ENVIAR", color = if (isFormComplete) Color.White else Color.Gray)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showForm6(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    FormScreen6(navController)
}
