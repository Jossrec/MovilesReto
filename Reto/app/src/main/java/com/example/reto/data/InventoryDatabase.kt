package com.example.reto.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * Database class with a singleton Instance object.
 */
//@Database(entities = [Item::class], version = 1, exportSchema = false)
//abstract class InventoryDatabase : RoomDatabase() {
//
//    abstract fun itemDao(): ItemDao
//
//    companion object {
//        @Volatile
//        private var Instance: InventoryDatabase? = null
//
//        fun getDatabase(context: Context): InventoryDatabase {
//            // if the Instance is not null, return it, otherwise create a new database instance.
//            return Instance ?: synchronized(this) {
//                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
//                    .fallbackToDestructiveMigration()
//                    .build()
//                    .also { Instance = it }
//            }
//        }
//    }
//}

@Database(entities = [Formulario_base::class, Formulario_7::class, Formulario_6::class,
    Formulario_5::class, Formulario_4::class, Formulario_3::class, Formulario_2::class, Formulario_1::class],
    version = 1, exportSchema = false)
@TypeConverters(UriListConverter::class)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun itemDaobase(): ItemDao
    abstract fun itemDao7(): ItemDao7
    abstract fun itemDao6(): ItemDao6
    abstract fun itemDao5(): ItemDao5
    abstract fun itemDao4(): ItemDao4
    abstract fun itemDao3(): ItemDao3
    abstract fun itemDao2(): ItemDao2
    abstract fun itemDao1(): ItemDao1

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