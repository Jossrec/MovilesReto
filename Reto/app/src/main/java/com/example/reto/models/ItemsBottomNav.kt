package com.example.reto.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.reto.navigation.NavScreen

sealed class ItemsBottomNav (
    val icon: ImageVector,
    val title: String,
    val ruta: String
) {
    data object ItemBottomNav1: ItemsBottomNav(
        Icons.Outlined.Home,
        "Home",
        NavScreen.HomeScreen.name
    )
    data object ItemBottomNav2: ItemsBottomNav(
        Icons.Outlined.Search,
        "Search" ,
                NavScreen.SearchScreen.name
    )
    data object ItemBottomNav3: ItemsBottomNav(
        Icons.Outlined.Settings,
        "Settings",
                NavScreen.SettingsScreen.name
    )

}
