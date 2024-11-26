package com.example.reto.ui.theme

import android.app.Application
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.reto.InventoryApplication
import com.example.reto.vista.Forms_6_2ViewModel
import com.example.reto.vista.Forms_7_2ViewModel
import com.example.reto.vista.Formulario_1ViewModel
import com.example.reto.vista.Formulario_1_2ViewModel
import com.example.reto.vista.Formulario_2_2ViewModel
import com.example.reto.vista.Formulario_3_2ViewModel
import com.example.reto.vista.Formulario_4_2ViewModel
import com.example.reto.vista.Formulario_5_2ViewModel
import com.example.reto.vista.SearchScreenViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEntryViewModel
//        initializer {
//            CreateAccountViewModel(inventoryApplication().container.itemsRepository)
//        }
        initializer {
            SearchScreenViewModel(inventoryApplication().container.itemsRepository)
        }
        initializer {
            Forms_7_2ViewModel(inventoryApplication().container.itemsRepository7, inventoryApplication().container.itemsRepository)
        }
        initializer {
            Formulario_1ViewModel(inventoryApplication().container.itemsRepository)
        }
        initializer {
            Forms_6_2ViewModel(inventoryApplication().container.itemsRepository6, inventoryApplication().container.itemsRepository)
        }
        initializer {
            Formulario_5_2ViewModel(inventoryApplication().container.itemsRepository5, inventoryApplication().container.itemsRepository)
        }
        initializer {
            Formulario_4_2ViewModel(inventoryApplication().container.itemsRepository4, inventoryApplication().container.itemsRepository)
        }
        initializer {
            Formulario_3_2ViewModel(inventoryApplication().container.itemsRepository3, inventoryApplication().container.itemsRepository)
        }
        initializer {
            Formulario_2_2ViewModel(inventoryApplication().container.itemsRepository2, inventoryApplication().container.itemsRepository)
        }
        initializer {
            Formulario_1_2ViewModel(inventoryApplication().container.itemsRepository1, inventoryApplication().container.itemsRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)
