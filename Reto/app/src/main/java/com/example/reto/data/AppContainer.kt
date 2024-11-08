package com.example.reto.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
    val itemsRepository2: ItemsRepository2
    val itemsRepository3: ItemsRepository3
    val itemsRepository4: ItemsRepository4
    val itemsRepository5: ItemsRepository5
    val itemsRepository6: ItemsRepository6
    val itemsRepository7: ItemsRepository7
    val itemsRepository8: ItemsRepository8
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
    override val itemsRepository4: ItemsRepository4 by lazy {
        OfflineItemsRepository4(InventoryDatabase2.getDatabase(context).itemDao6())
    }
    override val itemsRepository5: ItemsRepository5 by lazy {
        OfflineItemsRepository5(InventoryDatabase2.getDatabase(context).itemDao5())
    }
    override val itemsRepository6: ItemsRepository6 by lazy {
        OfflineItemsRepository6(InventoryDatabase2.getDatabase(context).itemDao4())
    }
    override val itemsRepository7: ItemsRepository7 by lazy {
        OfflineItemsRepository7(InventoryDatabase2.getDatabase(context).itemDao32())
    }
    override val itemsRepository8: ItemsRepository8 by lazy {
        OfflineItemsRepository8(InventoryDatabase2.getDatabase(context).itemDao1())
    }
}
