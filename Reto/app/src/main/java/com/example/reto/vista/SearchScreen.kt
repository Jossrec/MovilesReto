package com.example.reto.vista

import android.util.Log
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.components.NavegacionInferior
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reto.data.Formulario_base
import com.example.reto.ui.theme.AppViewModelProvider
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.RetoTheme
import com.example.reto.ui.theme.White
import com.example.reto.viewmodels.SharedViewModel
import com.example.reto.vista.movimientos.MovimientosTabs

//private val messages: List<MyMessage> = listOf(
//    MyMessage("Hola Jetpack Compose 1", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 2", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 3", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 4", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 5", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 6", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 7", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 8", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 9", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 10", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 11", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 12", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 13", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 14", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 15", "Preparado?"),
//    MyMessage("Hola Jetpack Compose 16", "Preparado?"),
//)


//data class MyMessage(val title: String, val body: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
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
                            "Búsqueda",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Black
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = Black,
                    scrolledContainerColor = GreenAwaq
                ),
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            NavegacionInferior(navController)
        },
    ) { innerPadding ->
        // Aquí agregamos las tabs
        //Log.i("email", sharedViewModel.email.value.toString())
        Column(modifier = Modifier.padding(innerPadding)) {
            MovimientosTabs(sharedViewModel) // Integra las tabs aquí
        }
    }
}


@Composable
fun MyMessages(messages: List<Formulario_base>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(messages) { message ->
            MyComponent(message)
        }
    }
}


@Composable
fun MyComponent(message: Formulario_base) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            MyImage()
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {

                Text(
                    //text = "#FM00001",
                    text = message.nombre,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    //text = "Fauna en Transectos",
                    text = message.Hora,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))


                Text(
                    text = message.fecha,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                )
            }

            IconButton(onClick = { /* Acción del menú */ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menú"
                )
            }
        }
    }
}


@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Preview(showSystemUi = true)
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
    RetoTheme {
        SearchScreen(navController = rememberNavController(), sharedViewModel = SharedViewModel())
        MyMessages(listOf(Formulario_base(1, "soypro@gmail.com" ,"Luis", "10/3/24","Monterrey", "10:30", "lluvia", "Invierno/Lluviosa", "Fauna de Trnasectos")))
    }
}