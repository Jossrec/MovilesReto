package com.example.reto.vista

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.reto.data.Formulario_6
import com.example.reto.data.Formulario_7
import com.example.reto.data.Item
import com.example.reto.data.ItemsRepository2
import com.example.reto.data.ItemsRepository4

/**
 * ViewModel to validate and insert items in the Room database.
 */
class Forms_6_2ViewModel(private val itemsRepository: ItemsRepository4, private val itemsRepositorybase: ItemsRepository2) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(Form6UiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: Form6Details) {
        itemUiState =
            Form6UiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    suspend fun getfromID(): Int {
        return itemsRepositorybase.getLastFormularioBaseId()?: -1
    }

    private fun validateInput(uiState: Form6Details = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            zona.isNotBlank()
                    && codigo.isNotBlank()
                    && fechaInstalacion.isNotBlank()
                    && nombreCamara.isNotBlank()
        }
    }
}

data class Form6UiState(
    val itemDetails: Form6Details = Form6Details(),
    val isEntryValid: Boolean = false
)

data class Form6Details(
    val id: Int = 0,
    val formId: Int = 0,
    val codigo: String = "",
    val zona: String = "",
    val nombreCamara: String = "",
    val placaCamara: String = "",
    val placaGuaya: String = "",
    val anchoCamino: String = "",
    val fechaInstalacion: String = "",
    val distanciaObjetivo: String = "",
    val alturaLente: String = "",
    val programada: Boolean = false,
    val memoria: Boolean = false,
    val pruebaDeGateo: Boolean = false,
    val instalada: Boolean = false,
    val letreroDeCamara: Boolean = false,
    val prendida: Boolean = false,
    val observaciones: String = ""
)

fun Form6Details.toItem(): Formulario_6 = Formulario_6(
    id = id,
    formId = formId,
    codigo = codigo,
    zona = zona,
    nombreCamara = nombreCamara,
    placaCamara = placaCamara,
    placaGuaya = placaGuaya,
    anchoCamino = anchoCamino,
    fechaInstalacion = fechaInstalacion,
    distanciaObjetivo = distanciaObjetivo,
    alturaLente = alturaLente,
    programada = programada,
    memoria = memoria,
    pruebaDeGateo = pruebaDeGateo,
    instalada = instalada,
    letreroDeCamara = letreroDeCamara,
    prendida = prendida,
    observaciones = observaciones

)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Formulario_6.toItemUiState(isEntryValid: Boolean = false): Form6UiState = Form6UiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Formulario_6.toItemDetails(): Form6Details = Form6Details(
    id = id,
    formId = formId,
    codigo = codigo,
    zona = zona,
    nombreCamara = nombreCamara,
    placaCamara = placaCamara,
    placaGuaya = placaGuaya,
    anchoCamino = anchoCamino,
    fechaInstalacion = fechaInstalacion,
    distanciaObjetivo = distanciaObjetivo,
    alturaLente = alturaLente,
    programada = programada,
    memoria = memoria,
    pruebaDeGateo = pruebaDeGateo,
    instalada = instalada,
    letreroDeCamara = letreroDeCamara,
    prendida = prendida,
    observaciones = observaciones
)