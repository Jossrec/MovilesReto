package com.example.reto.room

import androidx.room.Dao
import androidx.room.Insert
import com.example.reto.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)
}