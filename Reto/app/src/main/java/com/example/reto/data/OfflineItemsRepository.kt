package com.example.reto.data

import kotlinx.coroutines.flow.Flow

//class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
//    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()
//
//    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)
//
//    override suspend fun insertItem(item: Item) = itemDao.insert(item)
//
//    override suspend fun deleteItem(item: Item) = itemDao.delete(item)
//
//    override suspend fun updateItem(item: Item) = itemDao.update(item)
//}

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    override fun getAllItemsStream(email: String): Flow<List<Formulario_base>> = itemDao.getAllItems(email)

    override suspend fun getItemStream(id: Int): Formulario_base = itemDao.getItem(id)

    override suspend fun getLastFormularioBaseId(): Int?= itemDao.getLastFormularioBaseId()

    override suspend fun getNumberItems(email: String): Int? = itemDao.getNumberItems(email)

    override suspend fun insertItem(item: Formulario_base) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_base) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_base) = itemDao.update(item)
}

class OfflineItemsRepository1(private val itemDao: ItemDao1) : ItemsRepository1 {
    override fun getAllItemsStream(): Flow<List<Formulario_1>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario_1?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Formulario_1) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_1) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_1) = itemDao.update(item)
}

class OfflineItemsRepository2(private val itemDao: ItemDao2) : ItemsRepository2 {
    override fun getAllItemsStream(): Flow<List<Formulario_2>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario_2?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Formulario_2) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_2) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_2) = itemDao.update(item)
}

class OfflineItemsRepository3(private val itemDao: ItemDao3) : ItemsRepository3 {
    override fun getAllItemsStream(): Flow<List<Formulario_3>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario_3?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Formulario_3) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_3) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_3) = itemDao.update(item)
}

class OfflineItemsRepository4(private val itemDao: ItemDao4) : ItemsRepository4 {
    override fun getAllItemsStream(): Flow<List<Formulario_4>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario_4?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Formulario_4) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_4) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_4) = itemDao.update(item)
}

class OfflineItemsRepository5(private val itemDao: ItemDao5) : ItemsRepository5 {
    override fun getAllItemsStream(): Flow<List<Formulario_5>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario_5?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Formulario_5) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_5) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_5) = itemDao.update(item)
}

class OfflineItemsRepository6(private val itemDao: ItemDao6) : ItemsRepository6 {
    override fun getAllItemsStream(): Flow<List<Formulario_6>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario_6?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Formulario_6) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_6) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_6) = itemDao.update(item)
}

class OfflineItemsRepository7(private val itemDao: ItemDao7) : ItemsRepository7 {
    override fun getAllItemsStream(): Flow<List<Formulario_7>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Formulario_7?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Formulario_7) = itemDao.insert(item)

    override suspend fun deleteItem(item: Formulario_7) = itemDao.delete(item)

    override suspend fun updateItem(item: Formulario_7) = itemDao.update(item)
}








