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
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reto.R
import com.example.reto.ui.theme.AppViewModelProvider
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.RetoTheme
import kotlinx.coroutines.launch


data class Zona2(val nombre: String, var seleccionado: Boolean = false)

//Opcion unica de los circulos con su relleno
@Composable
private fun ZonaItem(zona: Zona2, onSelected: Boolean, onClick: () -> Unit) {
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
fun Forms_6_2(
    modifier: Modifier = Modifier,
    viewModel: Forms_6_2ViewModel = viewModel(factory = AppViewModelProvider.Factory),
    ) {
    val coroutineScope = rememberCoroutineScope()
    val valores = viewModel.itemUiState.itemDetails
    val Cambio = viewModel::updateUiState

    var zonaSeleccionada by remember { mutableStateOf<Zona2?>(null) }
    val listaZonas = remember{
        mutableStateListOf(
            Zona2("Bosque"),
            Zona2("Arreglo Agroforestal"),
            Zona2("Cultivos Transitorios"),
            Zona2("Cultivos Permanentes")
        )
    }
    val listaChequeo = remember{
        mutableStateListOf(
            Zona2("Programada"),
            Zona2("Memoria"),
            Zona2("Prueba de gateo"),
            Zona2("Instalada"),
            Zona2("Letrero de cámara"),
            Zona2("Prendida")
        )
    }
    val listaDatos = remember{
        mutableStateListOf(
            valores.programada,
            valores.memoria,
            valores.pruebaDeGateo,
            valores.instalada,
            valores.letreroDeCamara,
            valores.prendida
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
            item{
                OutlinedTextField(
                    value = valores.codigo,
                    onValueChange = { Cambio(valores.copy(codigo = it))
                    },
                    label = { Text(text = "Código") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{Text(text = "Zona", modifier = Modifier.padding(15.dp, 6.dp))}
            item{
                Column {
                    listaZonas.forEach { zona ->
                        ZonaItem(zona = zona, onSelected = zona == zonaSeleccionada){
                            zonaSeleccionada = zona
                            Cambio(valores.copy(zona = zona.nombre))
                        }
                    }
                }
            }
            item{
                OutlinedTextField(
                    value = valores.nombreCamara,
                    onValueChange = { Cambio(valores.copy(nombreCamara = it))
                    },
                    label = { Text(text = "Nombre Cámara") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = valores.placaCamara,
                    onValueChange = { Cambio(valores.copy(placaCamara = it))
                    },
                    label = { Text(text = "Placa Cámara") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = valores.placaGuaya,
                    onValueChange = { Cambio(valores.copy(placaGuaya = it))
                    },
                    label = { Text(text = "Placa Guaya") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = valores.anchoCamino,
                    onValueChange = { Cambio(valores.copy(anchoCamino = it))
                    },
                    label = { Text(text = "Ancho Camino mt") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = valores.fechaInstalacion,
                    onValueChange = { Cambio(valores.copy(fechaInstalacion = it))
                    },
                    label = { Text(text = "Fecha de Instalación") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = valores.distanciaObjetivo,
                    onValueChange = { Cambio(valores.copy(distanciaObjetivo = it))
                    },
                    label = { Text(text = "Distancia al objetivo mt") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                OutlinedTextField(
                    value = valores.alturaLente,
                    onValueChange = { Cambio(valores.copy(alturaLente = it))
                    },
                    label = { Text(text = "Altura del lente mt") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp),
                    singleLine = true,
                )
            }
            item{
                Text(text = "Lista de chequeo", modifier = Modifier.padding(15.dp, 0.dp))
            }
            //Opcion multiple de checkboxes
            item{
                listaChequeo.forEachIndexed {index, zona ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .padding(30.dp, 0.dp)
                    ) {
                        Checkbox(
                            checked = zona.seleccionado,
                            onCheckedChange = { isChecked ->
                                listaChequeo[index] = zona.copy(
                                    seleccionado = isChecked
                                )
                                val nuevoEstado = when (zona.nombre) {
                                    "Programada" -> valores.copy(programada = isChecked)
                                    "Memoria" -> valores.copy(memoria = isChecked)
                                    "Prueba de gateo" -> valores.copy(pruebaDeGateo = isChecked)
                                    "Instalada" -> valores.copy(instalada = isChecked)
                                    "Letrero de cámara" -> valores.copy(letreroDeCamara = isChecked)
                                    "Prendida" -> valores.copy(prendida = isChecked)
                                    else -> valores // Si no coincide, dejamos el objeto como está
                                }
                                Cambio(nuevoEstado)
                            }
                        )
                        Text(text = zona.nombre, Modifier.padding(3.dp))
                    }
                }
            }
            item{Text(text = "Evidencias", modifier = Modifier.padding(15.dp, 0.dp), fontWeight = FontWeight.Bold)}
            item{
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.green_black)
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(30.dp, 0.dp)
                ) {
                    Text(
                        text = "Elige Archivo",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            item{
                OutlinedTextField(
                    value = valores.observaciones,
                    onValueChange = { Cambio(valores.copy(observaciones = it))
                    },
                    label = { Text(text = "Observaciones") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 4.dp)
                        .size(120.dp),
                )
            }
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
                        onClick = {
                            coroutineScope.launch {
                                Cambio(valores.copy(formId = viewModel.getfromID()))
                                viewModel.saveItem()
                            }
                        },
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
fun Forms_6_2Preview() {
    RetoTheme {
        Forms_6_2(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}