package com.example.reto.vista

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.reto.R

import com.example.reto.components.NavegacionInferior
import com.example.reto.ui.theme.GreenAwaq

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController, currentCredentials: MutableState<Credentials?>) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.height(120.dp), // Aumenta la altura de la barra superior
                title = {
                    Box(
                        contentAlignment = Alignment.Center, // Centra el contenido vertical y horizontalmente
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            "Configuración",
                            fontSize = 50.sp, // Ajusta el tamaño de fuente para iPad
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
        Column(
            Modifier
                .padding(paddingValues)
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxSize()
        ) {
            Row(
                Modifier.padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profilepic),
                    contentDescription = "foto de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                )
                Column {
                    Text(
                        text = stringResource(R.string.profilename),
                        fontWeight = FontWeight.W500,
                        fontSize = 50.sp,
                        color = Black,
                        modifier = Modifier.padding(start = 20.dp)
                    )

                    Text(
                        text = stringResource(R.string.startdate),
                        fontWeight = FontWeight.W400,
                        fontSize = 30.sp,
                        color = Black,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(80.dp))
            Column(Modifier.padding(top = 50.dp)) {
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = "email",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = stringResource(R.string.correo),
                        fontSize = 30.sp,
                        modifier = Modifier.padding(start = 30.dp)
                    )
                }
                Spacer(modifier = Modifier.height(80.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            currentCredentials.value = null

                            navController.navigate("loginScreen") {
                                popUpTo("loginScreen") { inclusive = true }
                            }
                        },
                        modifier = Modifier.size(300.dp, 70.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = GreenAwaq,
                            contentColor = Black
                        )
                    ) {
                        Text("Cerrar Sesión", fontSize = 40.sp)
                    }
                }
            }
        }
    }
}




