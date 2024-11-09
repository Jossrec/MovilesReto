package com.example.reto.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
    val itemsRepository1: ItemsRepository1
    val itemsRepository2: ItemsRepository2
    val itemsRepository3: ItemsRepository3
    val itemsRepository4: ItemsRepository4
    val itemsRepository5: ItemsRepository5
    val itemsRepository6: ItemsRepository6
    val itemsRepository7: ItemsRepository7
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
//    override val itemsRepository: ItemsRepository by lazy {
//        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
//    }
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDaobase())
    }
    override val itemsRepository1: ItemsRepository1 by lazy {
        OfflineItemsRepository1(InventoryDatabase.getDatabase(context).itemDao1())
    }
    override val itemsRepository2: ItemsRepository2 by lazy {
        OfflineItemsRepository2(InventoryDatabase.getDatabase(context).itemDao2())
    }
    override val itemsRepository3: ItemsRepository3 by lazy {
        OfflineItemsRepository3(InventoryDatabase.getDatabase(context).itemDao3())
    }
    override val itemsRepository4: ItemsRepository4 by lazy {
        OfflineItemsRepository4(InventoryDatabase.getDatabase(context).itemDao4())
    }
    override val itemsRepository5: ItemsRepository5 by lazy {
        OfflineItemsRepository5(InventoryDatabase.getDatabase(context).itemDao5())
    }
    override val itemsRepository6: ItemsRepository6 by lazy {
        OfflineItemsRepository6(InventoryDatabase.getDatabase(context).itemDao6())
    }
    override val itemsRepository7: ItemsRepository7 by lazy {
        OfflineItemsRepository7(InventoryDatabase.getDatabase(context).itemDao7())
    }
}
