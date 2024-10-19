package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.reto.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reto.ui.theme.AppViewModelProvider
import com.example.reto.ui.theme.RetoTheme
import kotlinx.coroutines.launch

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterAuxiliarScreen(
    viewModel: CreateAccountViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    RegisterBody(
        itemUiState = viewModel.itemUiState,
        onItemValueChange = viewModel::updateUiState,
        onSaveClick = {
            coroutineScope.launch {
                viewModel.saveItem()
            }
        },
    )
}

@Composable
fun RegisterAuxiliarInput(
    itemDetails: ItemDetails,
    onValueChange: (ItemDetails) -> Unit = {},
){
    // Email Input
    OutlinedTextField(
        value = itemDetails.nombre,
        onValueChange = { onValueChange(itemDetails.copy(nombre = it)) },
        label = { Text(text = "Nombre") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        singleLine = true
    )
    // Contraseña Input
    OutlinedTextField(
        value = itemDetails.email,
        onValueChange = { onValueChange(itemDetails.copy(email = it)) },
        label = { Text(text = "Email") },
        //visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        singleLine = true
    )
    // Contraseña Input
    OutlinedTextField(
        value = itemDetails.contraseña,
        onValueChange = { onValueChange(itemDetails.copy(contraseña = it)) },
        label = { Text(text = "Contraseña") },
        //visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        singleLine = true
    )
}

@Composable
fun RegisterBody(
    itemUiState: ItemUiState,
    onItemValueChange: (ItemDetails) -> Unit,
    onSaveClick: () -> Unit,
) {
    // Variables para los campos de texto
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.fondo1),
            contentDescription = null,
            contentScale = ContentScale.Crop,  // Ajusta la imagen para que ocupe todo el espacio sin deformarse
            modifier = Modifier.fillMaxSize()
        )

        // Caja de contenido sobre la imagen
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Título "Bienvenido" en la parte superior
            Text(
                text = "Crea una\n cuenta",
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 150.dp)
                    .padding(start = 25.dp)
            )

            // Contenedor para los campos de entrada
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center) // Alinear el contenido de la columna al centro
            ) {
                // Título de sesión
                Text(
                    text = "Regístrate",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .padding(top=130.dp)
                )
                RegisterAuxiliarInput(
                    itemDetails = itemUiState.itemDetails,
                    onValueChange = onItemValueChange
                )
                // Botón de Entrar
                Button(
//                    onClick = {
//                        coroutineScope.launch {
//                            viewModel.saveItem()
//                        }
//                    },
                    onClick = onSaveClick,
                    modifier = Modifier
                        .width(150.dp)
                        .height(48.dp)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4D752D))
                ) {
                    Text(text = "REGISTRAR", fontSize = 16.sp)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RetoTheme {
        RegisterBody(itemUiState = ItemUiState(
            ItemDetails(
                nombre = "Item name", email = "example@gmail.com", contraseña = "password"
            )
        ), onItemValueChange = {}, onSaveClick = {})
    }
}

