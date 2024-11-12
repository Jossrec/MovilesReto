package com.example.reto.vista.movimientos

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reto.R
import com.example.reto.data.Formulario_base
import com.example.reto.ui.theme.AppViewModelProvider
import com.example.reto.ui.theme.White
import com.example.reto.vista.SearchScreenViewModel

@Composable
fun Todos(viewModel: SearchScreenViewModel = viewModel(factory = AppViewModelProvider.Factory)){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val searchUiState by viewModel.searchUiState.collectAsState()
//        Icon(
//            Icons.Outlined.EmojiEmotions,
//            "Todos")
//        Text(text ="Todos",
//            style= MaterialTheme.typography.titleMedium,
//            textAlign = Center
//        )
        MyMessages(messages = searchUiState.itemList)
    }
}

@Composable
fun Guardados(viewModel: SearchScreenViewModel = viewModel(factory = AppViewModelProvider.Factory)){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val searchUiState by viewModel.searchUiState.collectAsState()

//        Icon(Icons.Outlined.EmojiEmotions,
//            "Guardados")
//        Text(text ="Guardados",
//            style= MaterialTheme.typography.titleMedium,
//            textAlign = Center)
        MyMessages(messages = searchUiState.itemList)
    }
}

@Composable
fun Subidos(viewModel: SearchScreenViewModel = viewModel(factory = AppViewModelProvider.Factory)){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val searchUiState by viewModel.searchUiState.collectAsState()

//        Icon(Icons.Outlined.EmojiEmotions,
//            "Subidos")
//        Text(text ="Subidos",
//            style= MaterialTheme.typography.titleMedium,
//            textAlign = Center)
        MyMessages(messages = searchUiState.itemList)
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