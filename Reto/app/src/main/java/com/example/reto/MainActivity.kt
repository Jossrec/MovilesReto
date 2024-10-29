package com.example.reto

import FormScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.reto.vista.FormScreen2
import com.example.reto.vista.FormScreen3
import com.example.reto.vista.FormScreen5

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetoTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    FormScreen5()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavegacionInferior(navController)
        }
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
