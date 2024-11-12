package com.example.reto.vista
import android.content.Context
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.reto.R
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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

    // Estado para URI de imagen capturada o seleccionada
    var capturedImageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)

    // Lanzador para la cámara
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) capturedImageUri = uri
    }

    // Lanzador para la galería
    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { selectedUri ->
        capturedImageUri = selectedUri
    }

    // Lanzador para permisos de cámara
    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (granted) {
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permiso de cámara denegado", Toast.LENGTH_SHORT).show()
        }
    }

    // Función para seleccionar imagen (cámara o galería)
    fun selectImageOption() {
        val permissionCheckResult = ContextCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA)
        if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
            cameraLauncher.launch(uri) // Lanzar la cámara si el permiso está concedido
        } else {
            permissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Formulario", maxLines = 1) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = Black
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(route = "Formulario1") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                },
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

            Text("Evidencias", fontSize = 18.sp)
            Button(
                onClick = { selectImageOption() },
                colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Elige archivo")
            }

            // Vista previa de la imagen seleccionada
            capturedImageUri?.let { uri ->
                Image(
                    painter = rememberImagePainter(uri),
                    contentDescription = "Imagen seleccionada",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(200.dp)
                )
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


// Función para crear un archivo temporal de imagen
fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val imageFileName = "JPEG_${timeStamp}_"
    return File.createTempFile(imageFileName, ".jpg", externalCacheDir)
}

@Preview(showSystemUi = true)
@Composable
fun showFormScreen3 (modifier: Modifier = Modifier){
    var navController = rememberNavController()
    FormScreen3(navController)
}