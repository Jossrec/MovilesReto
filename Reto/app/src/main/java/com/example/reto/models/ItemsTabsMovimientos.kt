package com.example.reto.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Score
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.Feed
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material.icons.outlined.Score
import androidx.compose.material.icons.outlined.Upload
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reto.viewmodels.SharedViewModel
import com.example.reto.vista.movimientos.Guardados
import com.example.reto.vista.movimientos.Subidos
import com.example.reto.vista.movimientos.Todos

sealed class ItemsTabsMovimientos(
    var title: String,
    var iconSelected: ImageVector,
    var iconUnselected: ImageVector,
    var screen: @Composable (sharedViewModel: String) -> Unit
) {
    class TabTodos(sharedViewModel: String) : ItemsTabsMovimientos(
        "Todos",
        Icons.Filled.Feed,
        Icons.Outlined.Feed,
        { Todos(sharedViewModel = sharedViewModel) }
    )

    class TabGuardados(sharedViewModel: String) : ItemsTabsMovimientos(
        "Guardados",
        Icons.Filled.Save,
        Icons.Outlined.Save,
        { Guardados(sharedViewModel = sharedViewModel) }
    )

    class TabSubidos(sharedViewModel: String) : ItemsTabsMovimientos(
        "Subidos",
        Icons.Filled.Upload,
        Icons.Outlined.Upload,
        { Subidos(sharedViewModel = sharedViewModel) }
    )
}