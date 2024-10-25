package com.example.reto.vista

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.R
import com.example.reto.components.DoubleButton

import com.example.reto.components.HeaderBar
import com.example.reto.ui.theme.BotonAwaq
import com.example.reto.ui.theme.GreenAwaq

@Composable
fun Formulario1_2(){
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = { HeaderBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Content2()
            DoubleButton(scrollState)
        }

    }
}


@Composable
fun Content2() {
    val numeroDeTransecto = remember { mutableStateOf("") }
    var tipoAnimal by remember { mutableStateOf("Mamifero") }
    val nombreComun = remember { mutableStateOf("") }
    val nombreCientifico = remember { mutableStateOf("") }
    val numeroIndividuos = remember { mutableStateOf("") }
    var tipoObservacion by remember { mutableStateOf("La Vió") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Número de Transecto
            OutlinedTextField(
                value = numeroDeTransecto.value,
                onValueChange = { numeroDeTransecto.value = it },
                label = { Text("Numero de Transecto") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Column para tipo de animal
            Column {
                // Tipo de Animal
                Text(text = "Tipo de animal:")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(
                        onClick = { tipoAnimal = "Mamifero" },
                        modifier = Modifier
                            .background(if (tipoAnimal == "Mamifero") GreenAwaq else Color.Transparent)
                            .size(64.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.panda),  // Imagen de mamífero
                            contentDescription = "Mamifero",
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(
                        onClick = { tipoAnimal = "Ave" },
                        modifier = Modifier
                            .background(if (tipoAnimal == "Ave") GreenAwaq else Color.Transparent)
                            .size(64.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ave),  // Imagen de ave
                            contentDescription = "Ave",
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(
                        onClick = { tipoAnimal = "Reptil" },
                        modifier = Modifier
                            .background(if (tipoAnimal == "Reptil") GreenAwaq else Color.Transparent)
                            .size(64.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cocodrilo),  // Imagen de reptil
                            contentDescription = "Reptil",
                            tint = Color.Unspecified
                        )
                    }
                }
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround){
                    IconButton(
                        onClick = { tipoAnimal = "Anfibio" },
                        modifier = Modifier
                            .background(if (tipoAnimal == "Anfibio") GreenAwaq else Color.Transparent)
                            .size(64.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.anfibio),  // Imagen de anfibio
                            contentDescription = "Anfibio",
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(
                        onClick = { tipoAnimal = "Insecto" },
                        modifier = Modifier
                            .background(if (tipoAnimal == "Insecto") GreenAwaq else Color.Transparent)
                            .size(64.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.insecto),  // Imagen de insecto
                            contentDescription = "Insecto",
                            tint = Color.Unspecified
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre Común
            OutlinedTextField(
                value = nombreComun.value,
                onValueChange = { nombreComun.value = it },
                label = { Text("Nombre Común") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre Científico
            OutlinedTextField(
                value = nombreCientifico.value,
                onValueChange = { nombreCientifico.value = it },
                label = { Text("Nombre Científico (Opcional)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Número de Individuos
            OutlinedTextField(
                value = numeroIndividuos.value,
                onValueChange = { numeroIndividuos.value = it },
                label = { Text("Número de Individuos") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tipo de Observación
            Text(text = "Tipo de Observación:")
            Column {
                RadioButtonWithLabel("La Vió", tipoObservacion) { tipoObservacion = it }
                RadioButtonWithLabel("Huella", tipoObservacion) { tipoObservacion = it }
                RadioButtonWithLabel("Rastro", tipoObservacion) { tipoObservacion = it }
                RadioButtonWithLabel("Cacería", tipoObservacion) { tipoObservacion = it }
                RadioButtonWithLabel("Le Dijeron", tipoObservacion) { tipoObservacion = it }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para subir evidencia
            ImageUploadButton()

            Spacer(modifier = Modifier.height(16.dp))

            // Observaciones
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Observaciones") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }
    }
}


@Composable
fun RadioButtonWithLabel(label: String, selectedOption: String, onSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = (selectedOption == label),
            onClick = { onSelected(label) }
        )
        Text(text = label)
    }
}

@Composable
fun ImageUploadButton() {
    Row(
        modifier = Modifier.fillMaxWidth(), // Row ocupará todo el ancho
        horizontalArrangement = Arrangement.Start // Alinea el contenido a la izquierda
    ) {
        Button(
            onClick = { /* Aquí se manejaría la lógica para seleccionar archivos */ },
            modifier = Modifier
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BotonAwaq // Tu color personalizado
            )
        ) {
            Text(
                text = "Elige archivo",
                fontSize = 20.sp,        // Tamaño de fuente
                fontWeight = FontWeight.Bold // Texto grueso
            )
        }
    }
}
