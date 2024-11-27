package com.example.reto.vista

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reto.data.Formulario_base
import com.example.reto.data.ItemsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * ViewModel to retrieve all items in the Room database.
 */
class SearchScreenViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {
    private var emailU = MutableStateFlow("")
    //private val _numberItems = MutableLiveData<Int>()
    //val numberItems: LiveData<Int> get() = _numberItems
    fun emailUsuario(email: String) {
        emailU.value = email
    }
    suspend fun getnumbers(): Int {
        return try {
            itemsRepository.getNumberItems(emailU.value) ?: -1
        }
        catch (e: Exception) { // Maneja el error adecuadamente
            e.printStackTrace()
            0
            //_numberItems.postValue(-1)
        }
    }

    val searchUiState: StateFlow<SearchUiState> = emailU
        .flatMapLatest { email -> itemsRepository.getAllItemsStream(email).map { SearchUiState(it) } }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = SearchUiState()
            )

    suspend fun deleteItem(id: Int)
    { viewModelScope.launch {
            try {
                itemsRepository.deleteItem(itemsRepository.getItemStream(id))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Ui State for HomeScreen
 */
data class SearchUiState(val itemList: List<Formulario_base> = listOf())
