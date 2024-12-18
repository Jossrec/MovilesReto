package com.example.reto.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reto.models.ItemsBottomNav.*
import com.example.reto.navigation.currentRoute
import com.example.reto.ui.theme.GreenAwaq

@Composable
fun NavegacionInferior(
    navController: NavController
){
    val menuItems = listOf(
        ItemBottomNav1,
        ItemBottomNav2,
        ItemBottomNav3
    )

    BottomAppBar(
        modifier = Modifier.height(120.dp)
    ) {
        NavigationBar(
            containerColor = GreenAwaq
        ) {
            menuItems.forEach { item ->
                val selected = currentRoute(navController) == item.ruta
                NavigationBarItem(
                    selected = selected,
                    onClick = { navController.navigate(item.ruta) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(
                            text = item.title
                        )
                    }
                )
            }
        }
    }

}

