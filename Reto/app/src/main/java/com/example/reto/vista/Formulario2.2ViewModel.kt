package com.example.reto.vista

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reto.data.Formulario_2
import com.example.reto.data.ItemsRepository
import com.example.reto.data.ItemsRepository2

/**
 * ViewModel to validate and insert items in the Room database.
 */
class Formulario_2_2ViewModel(private val itemsRepository: ItemsRepository2, private val itemsRepositorybase: ItemsRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(Formulario_2UiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: Formulario_2Details) {
        itemUiState =
            Formulario_2UiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    suspend fun getfromID(): Int {
        return itemsRepositorybase.getLastFormularioBaseId()?: -1
    }


    private fun validateInput(uiState: Formulario_2Details = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            zona.isNotBlank()
                    && nombreComun.isNotBlank()
                    && numeroIndividuos.isNotBlank()
        }
    }
}

data class Formulario_2UiState(
    val itemDetails: Formulario_2Details = Formulario_2Details(),
    val isEntryValid: Boolean = false
)

data class Formulario_2Details(
    val id: Int = 0,
    val formId: Int = 0,
    val zona: String = "",
    val tipoAnimal: String = "",
    val nombreComun: String = "",
    val nombreCientifico: String = "",
    val numeroIndividuos: String = "",
    val TipoObservacion: String = "",
    val AlturaObservacion: String = "",
    val Imagenes: List<Uri> = listOf(),
    val observaciones: String = ""
)

fun Formulario_2Details.toItem(): Formulario_2 = Formulario_2(
    id = id,
    formId = formId,
    zona = zona,
    tipoAnimal = tipoAnimal,
    nombreComun = nombreComun,
    nombreCientifico = nombreCientifico,
    numeroIndividuos = numeroIndividuos.toIntOrNull() ?: 0,
    TipoObservacion = TipoObservacion,
    AlturaObservacion = AlturaObservacion,
    Imagenes = Imagenes,
    observaciones = observaciones
)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Formulario_2.toItemUiState(isEntryValid: Boolean = false): Formulario_2UiState = Formulario_2UiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Formulario_2.toItemDetails(): Formulario_2Details = Formulario_2Details(
    id = id,
    formId = formId,
    zona = zona,
    tipoAnimal = tipoAnimal,
    nombreComun = nombreComun,
    nombreCientifico = nombreCientifico,
    numeroIndividuos = numeroIndividuos.toString(),
    TipoObservacion = TipoObservacion,
    AlturaObservacion = AlturaObservacion,
    Imagenes = Imagenes,
    observaciones = observaciones
)