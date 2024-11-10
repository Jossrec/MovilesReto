package com.example.reto

import android.annotation.SuppressLint
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
import com.example.reto.models.ItemsTabsMovimientos
import com.example.reto.navigation.AppNavigation
import com.example.reto.ui.theme.RetoTheme
import com.example.reto.vista.Forms_6_2
import com.example.reto.vista.Forms_7_2
import com.example.reto.vista.Formulario1
import com.example.reto.vista.NuevaContra
import com.example.reto.vista.SearchScreen
import com.example.reto.vista.Verificacion
import com.example.reto.vista.movimientos.MovimientosTabs
import com.example.reto.vista.movimientos.Todos

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
                    //Forms_7_2()
                    //Forms_6_2()
                    MainScreen()
                }
            }
        }

    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
        Scaffold(
        ) {padding->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ){
                AppNavigation(navController = navController)
            }
        }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewComponent(){
    MainScreen()
}
