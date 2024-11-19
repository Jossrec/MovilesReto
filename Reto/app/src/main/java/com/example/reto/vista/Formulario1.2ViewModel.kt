package com.example.reto.vista

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reto.data.Formulario_1
import com.example.reto.data.ItemsRepository
import com.example.reto.data.ItemsRepository1

/**
 * ViewModel to validate and insert items in the Room database.
 */
class Formulario_1_2ViewModel(private val itemsRepository: ItemsRepository1, private val itemsRepositorybase: ItemsRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(Formulario_1UiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: Formulario_1Details) {
        itemUiState =
            Formulario_1UiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    suspend fun getfromID(): Int {
        return itemsRepositorybase.getLastFormularioBaseId()?: -1
    }


    private fun validateInput(uiState: Formulario_1Details = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            numeroTransecto.isNotBlank()
                    && nombreComun.isNotBlank()
                    && numeroIndividuos.isNotBlank()
        }
    }
}

data class Formulario_1UiState(
    val itemDetails: Formulario_1Details = Formulario_1Details(),
    val isEntryValid: Boolean = false
)

data class Formulario_1Details(
    val id: Int = 0,
    val formId: Int = 0,
    val numeroTransecto: String = "",
    val tipoAnimal: String = "",
    val nombreComun: String = "",
    val nombreCientifico: String = "",
    val numeroIndividuos: String = "",
    val TipoObservacion: String = "",
    val observaciones: String = ""
)

fun Formulario_1Details.toItem(): Formulario_1 = Formulario_1(
    id = id,
    formId = formId,
    numeroTransecto = numeroTransecto,
    tipoAnimal = tipoAnimal,
    nombreComun = nombreComun,
    nombreCientifico = nombreCientifico,
    numeroIndividuos = numeroIndividuos.toIntOrNull() ?: 0,
    TipoObservacion = TipoObservacion,
    observaciones = observaciones
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Formulario_1.toItemUiState(isEntryValid: Boolean = false): Formulario_1UiState = Formulario_1UiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Formulario_1.toItemDetails(): Formulario_1Details = Formulario_1Details(
    id = id,
    formId = formId,
    numeroTransecto = numeroTransecto,
    tipoAnimal = tipoAnimal,
    nombreComun = nombreComun,
    nombreCientifico = nombreCientifico,
    numeroIndividuos = numeroIndividuos.toString(),
    TipoObservacion = TipoObservacion,
    observaciones = observaciones,

)