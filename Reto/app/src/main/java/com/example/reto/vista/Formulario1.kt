package com.example.reto.vista

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import android.view.View.OnClickListener
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.components.HeaderBar
import com.example.reto.navigation.NavScreen
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro

import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.reto.components.HeaderBar
import com.example.reto.ui.theme.AppViewModelProvider

import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Formulario1(
    navController: NavHostController,
    viewModel: Formulario_1ViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val scrollState = rememberScrollState()
    var tipoRegistro by remember { mutableStateOf("Fauna en Transectos") } // Inicializa con uno por defecto

    Scaffold(
        topBar = { HeaderBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            // Primer componente desplazable
            Content(
                navController = navController,
                tipoRegistro = tipoRegistro,
                onTipoRegistroChange = { selectedTipoRegistro ->
                    tipoRegistro = selectedTipoRegistro
                },
//                valores = viewModel.itemUiState.itemDetails,
//                Cambio = viewModel::updateUiState
            )

            // Botón al final del contenido
//            Boton(
//                scrollState = scrollState,
//                tipoRegistro = tipoRegistro,
//                navController = navController,
//                coroutineScope = coroutineScope,
//                onNextClicked = {
//                        viewModel.saveItem()
//                }
//            )
        }
    }
}

//@Composable
//fun Boton(scrollState: ScrollState, tipoRegistro: String, navController: NavHostController, coroutineScope: CoroutineScope, onNextClicked: suspend () -> Unit) {
//    Button(
//        onClick = {
//            // Llama a la función para navegar a la siguiente pantalla
//            coroutineScope.launch {
//                onNextClicked() // Llamada dentro de la corutina
//                navController.navigate(tipoRegistro)
//            }
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 16.dp) ,
//            colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro)
//
//    ) {
//        Text(text = "Siguiente")
//    }
//}

@Composable
fun Content(
    modifier: Modifier = Modifier, navController: NavHostController, tipoRegistro: String, onTipoRegistroChange: (String) -> Unit,
//    valores: Formulario_baseDetails,
//    Cambio: (Formulario_baseDetails) -> Unit = {},
    viewModel: Formulario_1ViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    //Room
    val coroutineScope = rememberCoroutineScope()
    val valores = viewModel.itemUiState.itemDetails
    val Cambio = viewModel::updateUiState


    var estadoTiempo by remember { mutableStateOf("Soleado") }
    var epoca by remember { mutableStateOf("Verano/Seca") }
    Cambio(valores.copy(Estado_del_Tiempo = estadoTiempo, Época = epoca))


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp) // Aplica un padding, pero sin bordes ni fondo
    ) {
        // Nombre
        OutlinedTextField(
            value = valores.nombre,
            onValueChange = { Cambio(valores.copy(nombre = it)) },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Fecha
        OutlinedTextField(
            value = valores.fecha,
            onValueChange = { Cambio(valores.copy(fecha = it)) },
            label = { Text("Fecha") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Localidad con botón de ubicación
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = valores.Localidad,
                onValueChange = { Cambio(valores.copy(Localidad = it)) },
                label = { Text("Localidad") },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { navController.navigate("MapScreen")},
                colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro)
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Localizar",
                    tint = Color.White,
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Hora
        OutlinedTextField(
            value = valores.Hora,
            onValueChange = { Cambio(valores.copy(Hora = it))},
            label = { Text("Hora") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Estado del Tiempo (Íconos como botones)
        Text(text = "Estado del Tiempo:")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            IconButton(
                onClick = { estadoTiempo = "Soleado"
                    Cambio(valores.copy(Estado_del_Tiempo = estadoTiempo))
                },
                modifier = Modifier
                    .size(100.dp)
                    .background(if (estadoTiempo == "Soleado") GreenAwaq else Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.sol),
                    contentDescription = "Soleado",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(100.dp)
                )
            }
            IconButton(
                onClick = { estadoTiempo = "Parcialmente Nublado"
                    Cambio(valores.copy(Estado_del_Tiempo = estadoTiempo))},
                modifier = Modifier
                    .size(100.dp)
                    .background(if (estadoTiempo == "Parcialmente Nublado") GreenAwaq else Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.nube),
                    contentDescription = "Parcialmente Nublado",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(100.dp)
                )
            }

            IconButton(
                onClick = { estadoTiempo = "Lluvioso"
                    Cambio(valores.copy(Estado_del_Tiempo = estadoTiempo))},
                modifier = Modifier
                    .background(if (estadoTiempo == "Lluvioso") GreenAwaq else Color.Transparent)
                    .size(100.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.lluvia),
                    contentDescription = "Lluvioso",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(100.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Época (RadioButtons)
        Text(text = "Época:")
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = epoca == "Verano/Seca",
                onClick = { epoca = "Verano/Seca"
                    Cambio(valores.copy( Época = epoca))}
            )
            Text(text = "Verano/Seca")

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = epoca == "Invierno/Lluviosa",
                onClick = { epoca = "Invierno/Lluviosa"
                    Cambio(valores.copy( Época = epoca))
                }
            )
            Text(text = "Invierno/Lluviosa")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tipo de Registro (RadioButtons)
        Text(text = "Tipo de Registro:")
        Column {
            val tiposRegistro = listOf(
                "Fauna en Transectos" to NavScreen.Formulario12.name,
                "Fauna en Punto de Conteo" to NavScreen.Formulario22.name,
                "Fauna Búsqueda Libre" to NavScreen.Formulario32.name,
                "Validación de Cobertura" to NavScreen.Formulario42.name,
                "Parcela de Vegetación" to NavScreen.Formulario52.name,
                "Cámaras Trampa" to NavScreen.Formulario62.name,
                "Variables Climáticas" to NavScreen.Formulario72.name
            )
            tiposRegistro.forEach { (texto, ruta) ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = tipoRegistro == ruta,
                        onClick = { onTipoRegistroChange(ruta)
                        Cambio(valores.copy( Tipo_Registro = texto))
                        } // Solo actualiza el estado
                    )
                    Text(text = texto)
                }
            }
        }
        Button(
            onClick = {
                // Llama a la función para navegar a la siguiente pantalla
                coroutineScope.launch {
                    viewModel.saveItem()
                    navController.navigate(tipoRegistro)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp) ,
            colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro)

        ) {
            Text(text = "Siguiente")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFormulario1() {
    val navController = rememberNavController()
    Formulario1(navController)
}
