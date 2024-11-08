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

interface ItemsRepository4 {
    fun getAllItemsStream(): Flow<List<Formulario_6>>
    fun getItemStream(id: Int): Flow<Formulario_6?>
    suspend fun insertItem(item: Formulario_6)
    suspend fun deleteItem(item: Formulario_6)
    suspend fun updateItem(item: Formulario_6)
}

interface ItemsRepository5 {
    fun getAllItemsStream(): Flow<List<Formulario_5>>
    fun getItemStream(id: Int): Flow<Formulario_5?>
    suspend fun insertItem(item: Formulario_5)
    suspend fun deleteItem(item: Formulario_5)
    suspend fun updateItem(item: Formulario_5)
}

interface ItemsRepository6 {
    fun getAllItemsStream(): Flow<List<Formulario_4>>
    fun getItemStream(id: Int): Flow<Formulario_4?>
    suspend fun insertItem(item: Formulario_4)
    suspend fun deleteItem(item: Formulario_4)
    suspend fun updateItem(item: Formulario_4)
}

interface ItemsRepository7 {
    fun getAllItemsStream(): Flow<List<Formulario_3>>
    fun getItemStream(id: Int): Flow<Formulario_3?>
    suspend fun insertItem(item: Formulario_3)
    suspend fun deleteItem(item: Formulario_3)
    suspend fun updateItem(item: Formulario_3)
}

interface ItemsRepository8 {
    fun getAllItemsStream(): Flow<List<Formulario_1>>
    fun getItemStream(id: Int): Flow<Formulario_1?>
    suspend fun insertItem(item: Formulario_1)
    suspend fun deleteItem(item: Formulario_1)
    suspend fun updateItem(item: Formulario_1)
}
