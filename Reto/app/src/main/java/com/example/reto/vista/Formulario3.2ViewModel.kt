package com.example.reto.vista

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reto.data.Formulario_3
import com.example.reto.data.ItemsRepository
import com.example.reto.data.ItemsRepository3

/**
 * ViewModel to validate and insert items in the Room database.
 */
class Formulario_3_2ViewModel(private val itemsRepository: ItemsRepository3, private val itemsRepositorybase: ItemsRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(Formulario_3UiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: Formulario_3Details) {
        itemUiState =
            Formulario_3UiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    suspend fun getfromID(): Int {
        return itemsRepositorybase.getLastFormularioBaseId()?: -1
    }


    private fun validateInput(uiState: Formulario_3Details = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            zona.isNotBlank()
                    && nombreComun.isNotBlank()
                    && numeroIndividuos.isNotBlank()
        }
    }
}

data class Formulario_3UiState(
    val itemDetails: Formulario_3Details = Formulario_3Details(),
    val isEntryValid: Boolean = false
)

data class Formulario_3Details(
    val id: Int = 0,
    val formId: Int = 0,
    val zona: String = "",
    val tipoAnimal: String = "",
    val nombreComun: String = "",
    val nombreCientifico: String = "",
    val numeroIndividuos: String = "",
    val TipoObservacion: String = "",
    val AlturaObservacion: String = "",
    val observaciones: String = ""
)

fun Formulario_3Details.toItem(): Formulario_3 = Formulario_3(
    id = id,
    formId = formId,
    zona = zona,
    tipoAnimal = tipoAnimal,
    nombreComun = nombreComun,
    nombreCientifico = nombreCientifico,
    numeroIndividuos = numeroIndividuos.toIntOrNull() ?: 0,
    TipoObservacion = TipoObservacion,
    AlturaObservacion = AlturaObservacion,
    observaciones = observaciones
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Formulario_3.toItemUiState(isEntryValid: Boolean = false): Formulario_3UiState = Formulario_3UiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Formulario_3.toItemDetails(): Formulario_3Details = Formulario_3Details(
    id = id,
    formId = formId,
    zona = zona,
    tipoAnimal = tipoAnimal,
    nombreComun = nombreComun,
    nombreCientifico = nombreCientifico,
    numeroIndividuos = numeroIndividuos.toString(),
    TipoObservacion = TipoObservacion,
    AlturaObservacion = AlturaObservacion,
    observaciones = observaciones
)