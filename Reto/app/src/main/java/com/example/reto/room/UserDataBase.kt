package com.example.reto.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.reto.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UsersDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}