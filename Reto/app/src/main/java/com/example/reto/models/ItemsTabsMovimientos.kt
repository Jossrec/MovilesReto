package com.example.reto.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Score
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material.icons.outlined.Score
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.reto.vista.movimientos.Guardados
import com.example.reto.vista.movimientos.Subidos
import com.example.reto.vista.movimientos.Todos

sealed class ItemsTabsMovimientos(
    var title: String,
    var iconSelected: ImageVector,
    var iconUnselected: ImageVector,
    var screen: @Composable () -> Unit
) {
    object TabTodos : ItemsTabsMovimientos(
        "Todos",
        Icons.Filled.EmojiEmotions,
        Icons.Outlined.EmojiEmotions,
        { Todos() }
    )

    object TabGuardados : ItemsTabsMovimientos(
        "Guardados",
        Icons.Filled.Score,
        Icons.Outlined.Score,
        { Guardados() }
    )

    object TabSubidos : ItemsTabsMovimientos(
        "Subidos",
        Icons.Filled.MonetizationOn,
        Icons.Outlined.MonetizationOn,
        { Subidos() }
    )
}
