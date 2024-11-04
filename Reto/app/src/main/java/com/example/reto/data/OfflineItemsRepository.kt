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
    override fun getAllItemsStream(): Flow<List<Formulario1>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario1?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Formulario1) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario1) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario1) = itemDao.update(item)
}