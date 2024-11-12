package com.example.reto.vista

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reto.data.Formulario_4
import com.example.reto.data.ItemsRepository
import com.example.reto.data.ItemsRepository4

/**
 * ViewModel to validate and insert items in the Room database.
 */
class Formulario_4_2ViewModel(private val itemsRepository: ItemsRepository4, private val itemsRepositorybase: ItemsRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(Formulario_4UiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: Formulario_4Details) {
        itemUiState =
            Formulario_4UiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    suspend fun getfromID(): Int {
        return itemsRepositorybase.getLastFormularioBaseId()?: -1
    }

    private fun validateInput(uiState: Formulario_4Details = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            codigo.isNotBlank()
        }
    }
}

data class Formulario_4UiState(
    val itemDetails: Formulario_4Details = Formulario_4Details(),
    val isEntryValid: Boolean = false
)

data class Formulario_4Details(
    val id: Int = 0,
    val formId: Int = 0,
    val codigo: String = "",
    val Seguimiento: String = "",
    val Cambio: String = "",
    val Cobertura: String = "",
    val tipoCultivo: String = "",
    val Disturbio: String = "",
    val observaciones: String = ""
)

fun Formulario_4Details.toItem(): Formulario_4 = Formulario_4(
    id = id,
    formId = formId,
    codigo = codigo,
    Seguimiento = Seguimiento,
    Cambio = Cambio,
    Cobertura = Cobertura,
    tipoCultivo = tipoCultivo,
    Disturbio = Disturbio,
    observaciones = observaciones
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Formulario_4.toItemUiState(isEntryValid: Boolean = false): Formulario_4UiState = Formulario_4UiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Formulario_4.toItemDetails(): Formulario_4Details = Formulario_4Details(
    id = id,
    formId = formId,
    codigo = codigo,
    Seguimiento = Seguimiento,
    Cambio = Cambio,
    Cobertura = Cobertura,
    tipoCultivo = tipoCultivo,
    Disturbio = Disturbio,
    observaciones = observaciones
)