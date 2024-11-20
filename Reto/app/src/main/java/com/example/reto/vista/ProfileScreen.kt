package com.example.reto.vista

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import com.auth0.android.result.Credentials
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.reto.R

import com.example.reto.components.NavegacionInferior
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import com.example.reto.viewmodels.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController, currentCredentials: MutableState<Credentials?>,sharedViewModel: SharedViewModel) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val email by sharedViewModel.email.observeAsState("")
    val name = email.substringBefore('@')

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(

                title = {
                    Box(
                        contentAlignment = Alignment.Center, // Centra el contenido vertical y horizontalmente
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            "Configuración",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = com.example.reto.ui.theme.Black
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
        bottomBar = {
            NavegacionInferior(navController)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            // Imagen de fondo
            Image(
                painter = painterResource(id = R.drawable.transparentlogo),
                contentDescription = "Logo de fondo",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            )


            // Contenido principal de la pantalla
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                // Foto de perfil, nombre, etc.
                Column(
                    modifier = Modifier.padding(top = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profilepic),
                        contentDescription = "Foto de perfil",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = if (name.isNotEmpty())  "$name" else "Hola, Usuario",
                        fontWeight = FontWeight.W500,
                        fontSize = 50.sp,
                        color = Black
                    )
                    Text(
                        text = stringResource(R.string.correo),
                        fontWeight = FontWeight.W400,
                        fontSize = 30.sp,
                        color = Black
                    )
                }

                Spacer(modifier = Modifier.height(80.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 70.dp),
                    contentAlignment = Alignment.BottomCenter // Asegura que el botón esté en la parte inferior
                ) {
                    Button(
                        onClick = {
                            currentCredentials.value = null

                            navController.navigate("loginScreen") {
                                popUpTo("loginScreen") { inclusive = true }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f) // Ajusta el ancho del botón al 80% del contenedor
                            .height(70.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = GreenAwaq,
                            contentColor = Black
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text("Cerrar Sesión", fontSize = 20.sp)
                    }
                }
            }
        }
    }
}




