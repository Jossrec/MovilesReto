package com.example.reto.vista

import android.content.res.Configuration
import android.widget.CheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.R
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.RetoTheme
import com.example.reto.vista.NuevaContra


//Opcion unica de los circulos con su relleno
@Composable
private fun ZonaItem(zona: Zona, onSelected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(30.dp, 0.dp)
    ) {
        RadioButton(
            selected = onSelected,
            onClick = onClick
        )
        Text(text = zona.nombre, Modifier.padding(3.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Forms_7_2(modifier: Modifier = Modifier) {
    var pluviosidad by remember { mutableStateOf("") }
    var Temperatura_max by remember { mutableStateOf("") }
    var Humedad_max by remember { mutableStateOf("") }
    var Temperatura_min by remember { mutableStateOf("") }
    var Humedad_min by remember { mutableStateOf("") }
    var Quebrada by remember { mutableStateOf("") }

    var zonaSeleccionada by remember { mutableStateOf<Zona?>(null) }
    val listaZonas = remember{
        mutableStateListOf(
            Zona("Bosque"),
            Zona("Arreglo Agroforestal"),
            Zona("Cultivos Transitorios"),
            Zona("Cultivos Permanentes")
        )
    }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Formulario",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = Black,
                    scrolledContainerColor = GreenAwaq
                ),
                navigationIcon = {
                    IconButton(onClick = { /* Acción de navegación */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Descripción del ícono"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Acción del menú */ }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Descripción del ícono"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.padding(innerPadding)
        )
        {
            item{Text(text = "Zona", modifier = Modifier.padding(15.dp, 6.dp))}
            item{
                Column {
                    listaZonas.forEach { zona ->
                        ZonaItem(zona = zona, onSelected = zona == zonaSeleccionada){
                            zonaSeleccionada = zona
                        }
                    }
                }
            }
            item{
                OutlinedTextField(
                    value = pluviosidad,
                    onValueChange = { newText ->
                        pluviosidad = newText
                    },
                    label = { Text(text = "Pluviosidad (mm)") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = Temperatura_max,
                    onValueChange = { newText ->
                        Temperatura_max = newText
                    },
                    label = { Text(text = "Temperatura máxima") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = Humedad_max,
                    onValueChange = { newText ->
                        Humedad_max = newText
                    },
                    label = { Text(text = "Humedad máxima") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = Temperatura_min,
                    onValueChange = { newText ->
                        Temperatura_min = newText
                    },
                    label = { Text(text = "Temperatura mínima") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = Humedad_min,
                    onValueChange = { newText ->
                        Humedad_min = newText
                    },
                    label = { Text(text = "Humedad mínima") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = Quebrada,
                    onValueChange = { newText ->
                        Quebrada = newText
                    },
                    label = { Text(text = "Nivel Quebrada (mt)") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            //Opcion multiple de checkboxes
            item{
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.green_black)
                        ),
                        modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                    ) {
                        Text(
                            text = "ATRAS",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.green_black)
                        ),
                        modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp)
                    ) {
                        Text(
                            text = "ENVIAR",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Forms_7_2Preview() {
    RetoTheme {
        Forms_7_2(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}