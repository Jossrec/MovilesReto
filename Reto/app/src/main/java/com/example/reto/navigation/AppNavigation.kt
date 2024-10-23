package com.example.reto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reto.vista.EditProfile
import com.example.reto.vista.Formulario1
import com.example.reto.vista.Formulario1_2
import com.example.reto.vista.LoginScreen
import com.example.reto.vista.HomeScreen
import com.example.reto.vista.IntroScreen
import com.example.reto.vista.MapScreen
import com.example.reto.vista.MyMessage
import com.example.reto.vista.SearchScreen
import com.example.reto.vista.SettingsScreen


private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Jetpack Compose 1", "Preparado?"),
    MyMessage("Hola Jetpack Compose 2", "Preparado?"),
    MyMessage("Hola Jetpack Compose 3", "Preparado?"),
    MyMessage("Hola Jetpack Compose 4", "Preparado?"),
    MyMessage("Hola Jetpack Compose 5", "Preparado?"),
    MyMessage("Hola Jetpack Compose 6", "Preparado?"),
    MyMessage("Hola Jetpack Compose 7", "Preparado?"),
    MyMessage("Hola Jetpack Compose 8", "Preparado?"),
    MyMessage("Hola Jetpack Compose 9", "Preparado?"),
    MyMessage("Hola Jetpack Compose 10", "Preparado?"),
    MyMessage("Hola Jetpack Compose 11", "Preparado?"),
    MyMessage("Hola Jetpack Compose 12", "Preparado?"),
    MyMessage("Hola Jetpack Compose 13", "Preparado?"),
    MyMessage("Hola Jetpack Compose 14", "Preparado?"),
    MyMessage("Hola Jetpack Compose 15", "Preparado?"),
    MyMessage("Hola Jetpack Compose 16", "Preparado?"),
)

@Composable
fun AppNavigation(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = NavScreen.Formulario1_2.name
    ) {
        composable(NavScreen.HomeScreen.name){
            HomeScreen()
        }
        composable(NavScreen.SearchScreen.name){
            SearchScreen(messages)
        }
        composable(NavScreen.SettingsScreen.name){
            SettingsScreen(navController)
        }
        composable(NavScreen.ProfileScreen.name) {
            EditProfile(navController)
        }
        composable(NavScreen.Intro.name) {
            IntroScreen(navController)
        }
        composable(NavScreen.LoginScreen.name) {
            LoginScreen(navController = navController)
        }
        composable(NavScreen.MapScreen.name) {
            MapScreen(navController)
        }
        composable(NavScreen.Formulario1.name) {
            Formulario1()
        }
        composable(NavScreen.Formulario1_2.name) {
            Formulario1_2()
        }
    }
}
