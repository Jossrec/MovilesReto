package com.example.reto.vista

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reto.data.Formulario_5
import com.example.reto.data.ItemsRepository
import com.example.reto.data.ItemsRepository5

/**
 * ViewModel to validate and insert items in the Room database.
 */
class Formulario_5_2ViewModel(private val itemsRepository: ItemsRepository5, private val itemsRepositorybase: ItemsRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(Formulario_5UiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: Formulario_5Details) {
        itemUiState =
            Formulario_5UiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    suspend fun getfromID(): Int {
        return itemsRepositorybase.getLastFormularioBaseId()?: -1
    }

    private fun validateInput(uiState: Formulario_5Details = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            codigo.isNotBlank()
                    && nombreComunEspecie.isNotBlank()
        }
    }
}

data class Formulario_5UiState(
    val itemDetails: Formulario_5Details = Formulario_5Details(),
    val isEntryValid: Boolean = false
)

data class Formulario_5Details(
    val id: Int = 0,
    val formId: Int = 0,
    val codigo: String = "",
    val cuadrante: String = "",
    val subcuadrante: String = "",
    val habitoCrecimiento: String = "",
    val nombreComunEspecie: String = "",
    val nombreCientifico: String = "",
    val Placa: String = "",
    val Circunferencia: String = "",
    val Distancia: String = "",
    val estaturaBiomonitor: String = "",
    val Altura: String = "",
    val Imagenes: List<Uri> = listOf(),
    val observaciones: String = ""
)

fun Formulario_5Details.toItem(): Formulario_5 = Formulario_5(
    id = id,
    formId = formId,
    codigo = codigo,
    cuadrante = cuadrante,
    subcuadrante = subcuadrante,
    habitoCrecimiento = habitoCrecimiento,
    nombreComunEspecie = nombreComunEspecie,
    nombreCientifico = nombreCientifico,
    Placa = Placa,
    Circunferencia = Circunferencia,
    Distancia = Distancia,
    estaturaBiomonitor = estaturaBiomonitor,
    Altura = Altura,
    Imagenes = Imagenes,
    observaciones = observaciones
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Formulario_5.toItemUiState(isEntryValid: Boolean = false): Formulario_5UiState = Formulario_5UiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Formulario_5.toItemDetails(): Formulario_5Details = Formulario_5Details(
    id = id,
    formId = formId,
    codigo = codigo,
    cuadrante = cuadrante,
    subcuadrante = subcuadrante,
    habitoCrecimiento = habitoCrecimiento,
    nombreComunEspecie = nombreComunEspecie,
    nombreCientifico = nombreCientifico,
    Placa = Placa,
    Circunferencia = Circunferencia,
    Distancia = Distancia,
    estaturaBiomonitor = estaturaBiomonitor,
    Altura = Altura,
    Imagenes = Imagenes,
    observaciones = observaciones
)