package com.example.reto.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}

@Database(entities = [Formulario_base::class, Formulario_7::class], version = 2, exportSchema = false)
abstract class InventoryDatabase2 : RoomDatabase() {

    abstract fun itemDaobase(): ItemDao2
    abstract fun itemDao7(): ItemDao3

    companion object {
        @Volatile
        private var Instance: InventoryDatabase2? = null

        fun getDatabase(context: Context): InventoryDatabase2 {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase2::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}

//@Database(entities = [Formulario_7::class], version = 3, exportSchema = false)
//abstract class InventoryDatabase3 : RoomDatabase() {
//
//    abstract fun itemDao(): ItemDao3
//
//    companion object {
//        @Volatile
//        private var Instance: InventoryDatabase3? = null
//
//        fun getDatabase(context: Context): InventoryDatabase3 {
//            // if the Instance is not null, return it, otherwise create a new database instance.
//            return Instance ?: synchronized(this) {
//                Room.databaseBuilder(context, InventoryDatabase3::class.java, "item_database")
//                    .build()
//                    .also { Instance = it }
//            }
//        }
//    }
//}