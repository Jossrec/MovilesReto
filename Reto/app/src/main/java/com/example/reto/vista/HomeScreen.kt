package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.components.NavegacionInferior
import com.example.reto.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onLogout: () -> Unit, modifier: Modifier = Modifier, navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Box(modifier = Modifier  ) {
                Image(
                    painter = painterResource(id = R.drawable.semicirculo_removebg_preview),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )

                CenterAlignedTopAppBar(
                    modifier = Modifier.height(90.dp),
                    title = {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .align(Alignment.Center),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Text(
                                "Hola, Samantha",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.Black,
                                fontSize = 20.sp,
                                modifier = Modifier.wrapContentHeight()
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.Black
                    ),
                    navigationIcon = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.size(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.awaq_verde_vertical),
                                contentDescription = "Logo",
                                contentScale = ContentScale.Inside,
                                modifier = Modifier.size(100.dp)
                            )
                        }
                    },
                    actions = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.size(100.dp)
                        ) {
                            IconButton(onClick = { navController.navigate("ProfileScreen") }) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Perfil",
                                    tint = Color.Black,
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("Formulario1") },
                modifier = Modifier.size(100.dp)
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Nuevo formulario",
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        bottomBar = {
            NavegacionInferior(navController)
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(color = White)
            ) {
                DashboardContent(Modifier.padding(top = 32.dp))
            }
        }
    )
}
@Composable
fun DashboardContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmergencyMessageCard()

        Spacer(modifier = Modifier.height(16.dp))

        CircularProgressIndicator(
            progress = 0.6f,
            modifier = Modifier.size(200.dp),
            color = Color(0xFF9CCC65)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "60%", fontSize = 50.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "5 Forms", fontSize = 35.sp)
                Text(text = "En total", fontSize = 30.sp)
            }
            Spacer(modifier = Modifier.width(32.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "3 Forms", fontSize = 35.sp)
                Text(text = "Subidos", fontSize = 30.sp)
            }
            Spacer(modifier = Modifier.width(32.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "2 Forms", fontSize = 35.sp)
                Text(text = "Guardados", fontSize = 30.sp, color = Color.Red)
            }
        }
    }
}

@Composable
fun EmergencyMessageCard() {
    val cardColor = Color.Red
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Text(
            text = "¡Emergencia!\nTienes 2 formularios sin subir a la nube.",
            color = Color.White,
            modifier = Modifier.padding(16.dp),
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            lineHeight = 48.sp
        )
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(
        onLogout = { /* Acción simulada para cerrar sesión */ },
        navController = navController,
        modifier = Modifier.fillMaxSize()
    )
}
