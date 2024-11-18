package com.example.reto.vista

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.reto.MainActivity
import com.example.reto.R
import com.example.reto.components.CameraButton
import com.example.reto.components.HeaderBar
import com.example.reto.data.ItemDao2
import com.example.reto.ui.theme.AppViewModelProvider
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.RetoTheme
import com.example.reto.vista.NuevaContra
import kotlinx.coroutines.launch


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
fun FormScreen7(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: Forms_7_2ViewModel = viewModel(factory = AppViewModelProvider.Factory)

) {
    //Room
    val coroutineScope = rememberCoroutineScope()
    val valores = viewModel.itemUiState.itemDetails
    val Cambio = viewModel::updateUiState

//    var pluviosidad by remember { mutableStateOf("") }
//    var Temperatura_max by remember { mutableStateOf("") }
//    var Humedad_max by remember { mutableStateOf("") }
//    var Temperatura_min by remember { mutableStateOf("") }
//    var Humedad_min by remember { mutableStateOf("") }
//    var Quebrada by remember { mutableStateOf("") }

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
        topBar = { HeaderBar(navController) },
        floatingActionButton = {
            CameraButton(activity = LocalContext.current as MainActivity, navController)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize() // Asegúrate de que el LazyColumn ocupe el espacio disponible
        ) {
            item { Text(text = "Zona", modifier = Modifier.padding(15.dp, 6.dp)) }
            item {
                Column {
                    listaZonas.forEach { zona ->
                        ZonaItem(zona = zona, onSelected = zona == zonaSeleccionada) {
                            zonaSeleccionada = zona
                            Cambio(valores.copy(zona = zona.nombre))
                        }
                    }
                }
            }


            item{
                OutlinedTextField(
                    value = valores.Pluviosidad,
                    onValueChange = { Cambio(valores.copy(Pluviosidad = it))
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
                    value = valores.Temperatura_maxima,
                    onValueChange = { Cambio(valores.copy(Temperatura_maxima = it))
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
                    value = valores.Humedad_maxima,
                    onValueChange = { Cambio(valores.copy(Humedad_maxima = it))
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
                    value = valores.Temperatura_minima,
                    onValueChange = { Cambio(valores.copy(Temperatura_minima = it))
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
                    value = valores.Humedad_minima,
                    onValueChange = { Cambio(valores.copy(Humedad_minima = it))
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
                    value = valores.Nivel_Quebrada,
                    onValueChange = {Cambio(valores.copy(Nivel_Quebrada = it))
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
                        onClick = {
                            navController.navigate(route = "Formulario1")
                        },
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
                            navController.navigate(route = "SearchScreen")
                            coroutineScope.launch {
                                Cambio(valores.copy(formId = viewModel.getfromID()))
                                viewModel.saveItem()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.green_black)
                        ),
                        enabled = if(zonaSeleccionada == null){
                            false
                        }else{
                            true
                        },
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
