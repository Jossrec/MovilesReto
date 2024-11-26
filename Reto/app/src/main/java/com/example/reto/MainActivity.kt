package com.example.reto

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.auth0.android.Auth0


import com.example.reto.navigation.AppNavigation
import com.example.reto.room.UserRepository
import com.example.reto.room.UsersDataBase
import com.example.reto.ui.theme.RetoTheme
import com.example.reto.viewmodels.UserViewModelFactory


import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.reto.viewmodels.UserViewModel


class MainActivity : ComponentActivity() {
    private lateinit var account: Auth0

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Solicitar permisos
        if (!arePermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this, CAMERA_PERMISSION, 100
            )
        }

        // Inicializa la base de datos
        val database = Room.databaseBuilder(
            applicationContext,
            UsersDataBase::class.java, "app_database"
        ).build()

        account = Auth0.getInstance(
            getString(R.string.com_auth0_client_id),
            getString(R.string.com_auth0_domain)
        )


        // Crea el repositorio y el ViewModel
        val userRepository = UserRepository(database.userDao())
        val userViewModel = ViewModelProvider(
            this,
            UserViewModelFactory(userRepository)
        )[UserViewModel::class.java]

        setContent {
            RetoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen(userViewModel = userViewModel, account = account)
                }
            }
        }
    }

    fun arePermissionsGranted(): Boolean {
        return CAMERA_PERMISSION.all { perssion ->
            ContextCompat.checkSelfPermission(
                applicationContext,
                perssion
            ) == PackageManager.PERMISSION_GRANTED
        }
    }
    companion object {
        val CAMERA_PERMISSION = arrayOf(
            Manifest.permission.CAMERA
        )
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun MainScreen(userViewModel: UserViewModel, account: Auth0) {
    val navController = rememberNavController()
    var hasCameraPermission by remember { mutableStateOf(false) }



    Scaffold(
        bottomBar = {}
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            if (hasCameraPermission) {
                // Renderiza la navegación solo si los permisos fueron concedidos
                AppNavigation(navController, userViewModel, account)
            } else {
                // Renderiza algo alternativo si los permisos son denegados
                AppNavigation(navController, userViewModel, account)
            }
        }
    }
}