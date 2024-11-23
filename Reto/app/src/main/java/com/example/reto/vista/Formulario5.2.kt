package com.example.reto.vista

import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.reto.MainActivity
import com.example.reto.R
import com.example.reto.components.CameraButton
import com.example.reto.components.HeaderBar
import com.example.reto.ui.theme.AppViewModelProvider
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun FormScreen5(
    navController: NavController,
    viewModel: Formulario_5_2ViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    //Room
    val coroutineScope = rememberCoroutineScope()
    val valores = viewModel.itemUiState.itemDetails
    val Cambio = viewModel::updateUiState

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
    var selectedCuadrante by remember { mutableStateOf("") }
    var selectedSubCuadrante by remember { mutableStateOf(0) }
    var selectedHabito by remember { mutableStateOf("") }
    Cambio(valores.copy(cuadrante = selectedCuadrante, subcuadrante = selectedSubCuadrante.toString(), habitoCrecimiento = selectedHabito))

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
                valores.nombreComunEspecie.isNotBlank() &&
                valores.nombreCientifico.isNotBlank() &&
                valores.Placa.isNotBlank() &&
                valores.Circunferencia.isNotBlank() &&
                valores.Distancia.isNotBlank() &&
                valores.estaturaBiomonitor.isNotBlank() &&
                valores.Altura.isNotBlank()
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

            // Código
            OutlinedTextField(
                value = valores.codigo,
                onValueChange = { Cambio(valores.copy(codigo = it)) },
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
                                .clickable { selectedCuadrante = cuadrante
                                    Cambio(valores.copy(cuadrante = selectedCuadrante))
                                }
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
                                .clickable { selectedCuadrante = letra
                                    Cambio(valores.copy(cuadrante = selectedCuadrante))
                                }
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
                            .clickable { selectedSubCuadrante = numero
                                Cambio(valores.copy(subcuadrante = selectedSubCuadrante.toString()))
                            }
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "$numero",
                            fontSize = 16.sp,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                // Lógica para manejar la "no selección"
                if (selectedSubCuadrante == 0) {
                    Text(
                        text = "Ningún sub-cuadrante seleccionado",
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
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
                            .clickable { selectedHabito = tipo
                                Cambio(valores.copy(habitoCrecimiento = selectedHabito))
                            }
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
                value = valores.nombreComunEspecie,
                onValueChange = { Cambio(valores.copy(nombreComunEspecie = it)) },
                label = { Text("Nombre Común Especie") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre Científico
            OutlinedTextField(
                value = valores.nombreCientifico,
                onValueChange = { Cambio(valores.copy(nombreCientifico = it)) },
                label = { Text("Nombre Científico") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Placa
            OutlinedTextField(
                value = valores.Placa,
                onValueChange = { Cambio(valores.copy(Placa = it)) },
                label = { Text("Placa") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Circunferencia en cm (CL)
            OutlinedTextField(
                value = valores.Circunferencia,
                onValueChange = { Cambio(valores.copy(Circunferencia = it)) },
                label = { Text("Circunferencia en cm (CL)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Distancia en mt
            OutlinedTextField(
                value = valores.Distancia,
                onValueChange = { Cambio(valores.copy(Distancia = it)) },
                label = { Text("Distancia en mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Estatura Biomonitor en mt
            OutlinedTextField(
                value = valores.estaturaBiomonitor,
                onValueChange = { Cambio(valores.copy(estaturaBiomonitor = it)) },
                label = { Text("Estatura Biomonitor en mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Altura en mt
            OutlinedTextField(
                value = valores.Altura,
                onValueChange = { Cambio(valores.copy(Altura = it)) },
                label = { Text("Altura en mt") },
                modifier = Modifier.fillMaxWidth()
            )

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
                    onClick = {
                        navController.navigate(route = "SearchScreen")
                        coroutineScope.launch{
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
                    Text(
                        "ENVIAR",
                        color = if (isFormComplete) Color.White else Color.Gray
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