package com.example.reto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold


import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.reto.components.NavegacionInferior
import com.example.reto.navigation.AppNavigation
import com.example.reto.ui.theme.RetoTheme
import com.example.reto.vista.CreateAccountScreen
import com.example.reto.vista.Forms_6_2
import com.example.reto.vista.Forms_7_2
import com.example.reto.vista.Formulario1
import com.example.reto.vista.ItemDetails
import com.example.reto.vista.ItemUiState
import com.example.reto.vista.NuevaContra
import com.example.reto.vista.RegisterBody
import com.example.reto.vista.SearchScreen
import com.example.reto.vista.Verificacion

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetoTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    //CreateAccountScreen()
                    //Formulario1()
                    Forms_7_2()
                    //SearchScreen()
                }
            }
        }
    }
}

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
//@Composable
//fun MainScreen() {
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = {
//            NavegacionInferior(navController)
//        }
//    ) {padding->
//        Box(
//            modifier = Modifier
//                .padding(padding)
//                .fillMaxSize()
//        ){
//            AppNavigation(navController = navController)
//        }
//
//    }
//
//}
//
//@Preview(showSystemUi = true)
//@Composable
//fun RegisterScreenPreview(){
//    RetoTheme {
//        RegisterBody(itemUiState = ItemUiState(
//            ItemDetails(
//                //nombre = "Item name", email = "example@gmail.com", contraseña = "password"
//            )
//        ), onItemValueChange = {}, onSaveClick = {})
//    }
//}