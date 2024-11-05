package com.example.reto.vista

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reto.data.Formulario_7
import com.example.reto.data.Item
import com.example.reto.data.ItemsRepository
import com.example.reto.data.ItemsRepository2
import com.example.reto.data.ItemsRepository3

/**
 * ViewModel to validate and insert items in the Room database.
 */
class Forms_7_2ViewModel(private val itemsRepository: ItemsRepository3, private val itemsRepositorybase: ItemsRepository2) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(Form7UiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: Form7Details) {
        itemUiState =
            Form7UiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    suspend fun getfromID(): Int {
        return itemsRepositorybase.getLastFormularioBaseId()?: -1
    }

    private fun validateInput(uiState: Form7Details = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            zona.isNotBlank()
                    && Pluviosidad.isNotBlank()
                    && Temperatura_maxima.isNotBlank()
                    && Humedad_maxima.isNotBlank()
                    && Temperatura_minima.isNotBlank()
                    && Humedad_minima.isNotBlank()
                    && Nivel_Quebrada.isNotBlank()
        }
    }
}

data class Form7UiState(
    val itemDetails: Form7Details = Form7Details(),
    val isEntryValid: Boolean = false
)

data class Form7Details(
    val id: Int = 0,
    val formId: Int = 0,
    var zona: String = "",
    val Pluviosidad: String = "",
    val Temperatura_maxima: String = "",
    val Humedad_maxima: String = "",
    val Temperatura_minima: String = "",
    val Humedad_minima: String = "",
    val Nivel_Quebrada: String = ""
)

fun Form7Details.toItem(): Formulario_7 = Formulario_7(
    id = id,
    formId = formId,
    zona = zona,
    Pluviosidad = Pluviosidad,
    Temperatura_maxima = Temperatura_maxima,
    Humedad_maxima = Humedad_maxima,
    Temperatura_minima = Temperatura_minima,
    Humedad_minima = Humedad_minima,
    Nivel_Quebrada = Nivel_Quebrada

)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Formulario_7.toItemUiState(isEntryValid: Boolean = false): Form7UiState = Form7UiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Formulario_7.toItemDetails(): Form7Details = Form7Details(
    id = id,
    formId = formId,
    zona = zona,
    Pluviosidad = Pluviosidad,
    Temperatura_maxima = Temperatura_maxima,
    Humedad_maxima = Humedad_maxima,
    Temperatura_minima = Temperatura_minima,
    Humedad_minima = Humedad_minima,
    Nivel_Quebrada = Nivel_Quebrada
)
