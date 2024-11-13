package com.example.reto.vista

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.ui.theme.GreenAwaq

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditInfoScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.height(120.dp),
                title = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            "Configuración",
                            fontSize = 50.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = com.example.reto.ui.theme.Black
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .size(80.dp) // Tamaño más grande para el botón en general
                            .padding(vertical = 20.dp) // Alinea verticalmente dentro del AppBar
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = com.example.reto.ui.theme.Black,
                            modifier = Modifier.size(50.dp) // Tamaño más grande para el icono de flecha
                        )
                    }
                },

                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = com.example.reto.ui.theme.Black,
                    scrolledContainerColor = GreenAwaq
                ),
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(start = 20.dp, end = 20.dp, top = 140.dp)
                .fillMaxSize()
        ) {
            Column {
                Text(
                    text = "Nombre",
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(text = stringResource(R.string.profilename)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp), // Ajusta la altura de la caja aquí
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 40.sp // Ajusta el tamaño del texto aquí
                    ),
                    singleLine = true // Esto ayuda a mantener el texto en una sola línea si es necesario
                )
            }


            Divider()
            Spacer(modifier = Modifier.padding(10.dp))

            Column {
                Text(
                    text = "Correo",
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = stringResource(R.string.correo)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp), // Ajusta la altura de la caja aquí
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 40.sp // Ajusta el tamaño del texto aquí
                    ),
                    singleLine = true // Mantiene el texto en una sola línea
                )
            }


            Divider()
            Spacer(modifier = Modifier.padding(10.dp))

            Column {
                Text(
                    text = "Celular",
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = { Text(text = stringResource(R.string.numerocel)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp), // Ajusta la altura de la caja aquí
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 40.sp // Ajusta el tamaño del texto aquí
                    ),
                    singleLine = true // Mantiene el texto en una sola línea
                )
            }


            Divider()
            Spacer(modifier = Modifier.padding(30.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    onClick = { navController.navigate("ProfileScreen") },
                    modifier = Modifier.size(300.dp, 70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenAwaq,
                        contentColor = White
                    )
                ) {
                    Text("Confirmar", fontSize = 40.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showModif(modifier: Modifier = Modifier) {
    EditInfoScreen(navController = rememberNavController())
}
