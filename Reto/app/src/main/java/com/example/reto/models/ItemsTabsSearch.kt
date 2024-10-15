//package com.example.reto.models
//
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.EmojiEmotions
//import androidx.compose.material.icons.outlined.EmojiEmotions
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.vector.ImageVector
//import com.example.reto.vista.tabsSearch.Todos
//
//sealed class ItemsTabsSearch (
//    var title: String,
//    var iconSelected: ImageVector,
//    var iconUnselected: ImageVector,
//    var screen: @Composable() -> Unit
//){
//    object tabTodos: ItemsTabsSearch(
//        "Todos",
//        Icons.Filled.EmojiEmotions,
//        Icons.Outlined.EmojiEmotions,
//        {Todos()}
//    )
//    object tabGuardados: ItemsTabsSearch(
//        "Todos",
//        Icons.Filled.EmojiEmotions,
//        Icons.Outlined.EmojiEmotions,
//        {Guardados()}
//    )
//    object tabSubidos: ItemsTabsSearch(
//        "Subidos",
//        Icons.Filled.EmojiEmotions,
//        Icons.Outlined.EmojiEmotions,
//        {Subidos()}
//    )
//
//}
//
//
