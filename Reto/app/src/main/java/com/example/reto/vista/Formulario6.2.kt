package com.example.reto.vista

import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.reto.R
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen6(navController: NavController) {

    var observations by remember { mutableStateOf("") }
    var selectedZona by remember { mutableStateOf(value = "Bosque") }
    var codigo by remember { mutableStateOf(value = "") }
    var nomcamara by remember { mutableStateOf(value = "") }
    var placacamara by remember { mutableStateOf(value = "") }
    var placaguaya by remember { mutableStateOf(value = "") }
    var anchocamino by remember { mutableStateOf(value = "") }
    var fechainstalacion by remember { mutableStateOf(value = "") }
    var distobjetivo by remember { mutableStateOf(value = "") }
    var altlente by remember { mutableStateOf(value = "") }

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


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Formulario", maxLines = 1) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = com.example.reto.ui.theme.Black
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

            OutlinedTextField(
                value = codigo,
                onValueChange = { codigo= it },
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
                            onClick = { selectedZona = zona }
                        )
                        Text(zona)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nomcamara,
                onValueChange = { nomcamara = it },
                label = { Text("Nombre Cámara") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = placacamara,
                onValueChange = { placacamara = it },
                label = { Text("Placa Cámara") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = placaguaya,
                onValueChange = { placaguaya = it },
                label = { Text("Placa Guaya") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = anchocamino,
                onValueChange = { anchocamino = it },
                label = { Text("Ancho Camino mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = fechainstalacion,
                onValueChange = { fechainstalacion = it },
                label = { Text("Fecha de Instalación") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = distobjetivo,
                onValueChange = { distobjetivo= it },
                label = { Text("Distancia al objetivo mt") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = altlente,
                onValueChange = { altlente= it },
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

            // Evidencias (botón para elegir archivos
            Text("Evidencias", fontSize = 18.sp)
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro),
                modifier = Modifier.fillMaxWidth()
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
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Text("ATRÁS", color = Color.White)
                }
                Button(
                    onClick = { navController.navigate(route = "HomeScreen") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenAwaqOscuro
                    ),
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showForm6(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    FormScreen6(navController)
}
