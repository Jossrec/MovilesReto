package com.example.reto.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
interface ItemsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: Item)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: Item)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: Item)
}

interface ItemsRepository2 {
    fun getAllItemsStream(): Flow<List<Formulario_base>>
    fun getItemStream(id: Int): Flow<Formulario_base?>
    suspend fun getLastFormularioBaseId(): Int?
    suspend fun insertItem(item: Formulario_base)
    suspend fun deleteItem(item: Formulario_base)
    suspend fun updateItem(item: Formulario_base)
}

interface ItemsRepository3 {
    fun getAllItemsStream(): Flow<List<Formulario_7>>
    fun getItemStream(id: Int): Flow<Formulario_7?>
    suspend fun insertItem(item: Formulario_7)
    suspend fun deleteItem(item: Formulario_7)
    suspend fun updateItem(item: Formulario_7)
}
