package com.example.reto.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
    val itemsRepository2: ItemsRepository2
    val itemsRepository3: ItemsRepository3
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
    override val itemsRepository2: ItemsRepository2 by lazy {
        OfflineItemsRepository2(InventoryDatabase2.getDatabase(context).itemDaobase())
    }
    override val itemsRepository3: ItemsRepository3 by lazy {
        OfflineItemsRepository3(InventoryDatabase2.getDatabase(context).itemDao7())
    }
}
