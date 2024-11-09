package com.example.reto.vista

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reto.data.Formulario_7
import com.example.reto.data.Formulario_base
import com.example.reto.data.ItemsRepository
import com.example.reto.data.ItemsRepository2
import com.example.reto.data.ItemsRepository3

/**
 * ViewModel to validate and insert items in the Room database.
 */
class Formulario_1ViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(Formulario_baseUiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: Formulario_baseDetails) {
        itemUiState =
            Formulario_baseUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    private fun validateInput(uiState: Formulario_baseDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            nombre.isNotBlank()
                    && fecha.isNotBlank()
                    && Localidad.isNotBlank()
                    && Hora.isNotBlank()
                    && Estado_del_Tiempo.isNotBlank()
                    && Época.isNotBlank()
                    && Tipo_Registro.isNotBlank()
        }
    }
}

data class Formulario_baseUiState(
    val itemDetails: Formulario_baseDetails = Formulario_baseDetails(),
    val isEntryValid: Boolean = false
)

data class Formulario_baseDetails(
    val id: Int = 0,
    val nombre: String = "",
    val fecha: String = "",
    val Localidad: String = "",
    val Hora: String = "",
    val Estado_del_Tiempo: String = "",
    val Época: String = "",
    val Tipo_Registro: String = ""
)

fun Formulario_baseDetails.toItem(): Formulario_base = Formulario_base(
    id = id,
    nombre = nombre,
    fecha = fecha,
    Localidad = Localidad,
    Hora = Hora,
    Estado_del_Tiempo = Estado_del_Tiempo,
    Época = Época,
    Tipo_Registro = Tipo_Registro
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Formulario_base.toItemUiState(isEntryValid: Boolean = false): Formulario_baseUiState = Formulario_baseUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Formulario_base.toItemDetails(): Formulario_baseDetails = Formulario_baseDetails(
    id = id,
    nombre = nombre,
    fecha = fecha,
    Localidad = Localidad,
    Hora = Hora,
    Estado_del_Tiempo = Estado_del_Tiempo,
    Época = Época,
    Tipo_Registro = Tipo_Registro
)