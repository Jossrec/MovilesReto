package com.example.reto.navigation

import FormScreen
import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.reto.vista.FormScreen42
import com.example.reto.vista.FormScreen2
import com.example.reto.vista.FormScreen3
import com.example.reto.vista.FormScreen5
import com.example.reto.vista.FormScreen6
import com.example.reto.vista.FormScreen7
import com.example.reto.vista.Formulario1
import com.example.reto.vista.LoginScreen
import com.example.reto.vista.EditInfoScreen
import com.example.reto.vista.EditPasswordScreen
import com.example.reto.vista.HomeScreen
import com.example.reto.vista.IntroScreen
import com.example.reto.vista.MapScreen
import com.example.reto.vista.Profile
import com.example.reto.vista.SearchScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.auth0.android.result.Credentials
import com.example.reto.MainActivity
import com.example.reto.viewmodels.UserViewModel
import com.auth0.android.Auth0
import com.example.reto.data.ItemsRepository
import com.example.reto.vista.AuthApp
import com.example.reto.vista.Formulario_1ViewModel


@Composable
fun AppNavigation(
    navController: NavHostController,
    userViewModel: UserViewModel,
    auth0: Auth0
) {
    var loggedIn by remember { mutableStateOf(false) }
    var credentials by remember { mutableStateOf<Credentials?>(null) }

    // Verifica el estado de autenticación en tiempo de ejecución
    AuthApp(
        auth0 = auth0,
        onLoginSuccess = { creds ->
            credentials = creds
            loggedIn = true
        },
        onLogout = {
            loggedIn = false
        }
    )

    NavHost(
        navController = navController,
        startDestination = if (loggedIn) NavScreen.HomeScreen.name else NavScreen.Intro.name
    ) {
        composable(NavScreen.HomeScreen.name) {
            HomeScreen(
                navController = navController, // Pasa navController aquí
                onLogout = {
                    loggedIn = false
                    navController.navigate(NavScreen.LoginScreen.name) {
                        popUpTo(NavScreen.HomeScreen.name) { inclusive = true }
                    }
                }
            )
        }

        composable(NavScreen.SearchScreen.name){
            SearchScreen(navController)
        }
        composable(NavScreen.EditInfoScreen.name){
            EditInfoScreen(navController)
        }
        composable(NavScreen.ProfileScreen.name) {
            val activity = LocalContext.current as Activity // Obtén la actividad actual
            Profile(navController, auth0 = auth0, activity = activity)
        }
        composable(NavScreen.Intro.name) {
            IntroScreen(navController)
        }
        composable(NavScreen.LoginScreen.name) {
            LoginScreen(
                navController = navController,
                auth0 = auth0,
                onLoginSuccess = { creds ->
                    credentials = creds
                    loggedIn = true
                    navController.navigate(NavScreen.HomeScreen.name) {
                        popUpTo(NavScreen.LoginScreen.name) { inclusive = true }
                    }
                }
            )
        }
        composable(NavScreen.MapScreen.name) {
            MapScreen(navController)
        }
        composable(NavScreen.Formulario1.name) {
            Formulario1(navController)
        }
        composable(NavScreen.Formulario12.name){
            FormScreen(navController)
        }
        composable(NavScreen.Formulario22.name){
            FormScreen2(navController)
        }
        composable(NavScreen.Formulario32.name){
            FormScreen3(navController)
        }
        composable(NavScreen.Formulario42.name){
            FormScreen42(navController)
        }
        composable(NavScreen.Formulario52.name){
            FormScreen5(navController)
        }
        composable(NavScreen.Formulario62.name){
            FormScreen6(navController)
        }
        composable(NavScreen.Formulario72.name){
            FormScreen7(navController)
        }
        composable(NavScreen.EditPasswordScreen.name) {
            EditPasswordScreen(navController)
        }

    }
}
