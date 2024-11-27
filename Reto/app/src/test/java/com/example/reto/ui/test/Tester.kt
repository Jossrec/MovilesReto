package com.example.reto.ui.test

import com.example.reto.data.Formulario_base
import com.example.reto.data.ItemsRepository
import com.example.reto.vista.Formulario_1ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

// Implementación de ItemsRepository para pruebas
class TestItemsRepository : ItemsRepository {
    private val itemsFlow = MutableStateFlow<List<Formulario_base>>(emptyList())
    override fun getAllItemsStream(): Flow<List<Formulario_base>> = itemsFlow

    override fun getItemStream(id: Int): Flow<Formulario_base?> = flowOf(null)

    override suspend fun getLastFormularioBaseId(): Int? = 0

    override suspend fun insertItem(item: Formulario_base) {
    }

    override suspend fun deleteItem(item: Flow<Formulario_base?>) {
    }

    override suspend fun updateItem(item: Formulario_base) {
    }
}



class Tester {
    private lateinit var itemsRepository: ItemsRepository
    private lateinit var viewModel: Formulario_1ViewModel


    @Before
    fun setup() {
        itemsRepository = TestItemsRepository()
        viewModel = Formulario_1ViewModel(itemsRepository)

    }

    @Test
    fun Validar_datos_no_en_blanco_de_validateInput() {
        val nombreprueba = ""

        // Obtener el estado actual y actualizarlo
        val nombreavalidar = viewModel.itemUiState
        val Cambio = viewModel::updateUiState

        // Actualizar el nombre en el estado
        Cambio(nombreavalidar.itemDetails.copy(nombre = nombreprueba))

        assertFalse(viewModel.itemUiState.itemDetails.nombre.isNotBlank())
    }
}
