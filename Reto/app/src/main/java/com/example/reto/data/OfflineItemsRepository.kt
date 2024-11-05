package com.example.reto.data

import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    override suspend fun updateItem(item: Item) = itemDao.update(item)
}

class OfflineItemsRepository2(private val itemDao: ItemDao2) : ItemsRepository2 {
    override fun getAllItemsStream(): Flow<List<Formulario_base>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario_base?> = itemDao.getItem(id)

    override suspend fun getLastFormularioBaseId(): Int?= itemDao.getLastFormularioBaseId()

    override suspend fun insertItem(item: Formulario_base) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_base) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_base) = itemDao.update(item)
}

class OfflineItemsRepository3(private val itemDao: ItemDao3) : ItemsRepository3 {
    override fun getAllItemsStream(): Flow<List<Formulario_7>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario_7?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Formulario_7) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_7) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_7) = itemDao.update(item)
}
