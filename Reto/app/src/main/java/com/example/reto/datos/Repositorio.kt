package com.example.reto.datos

import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    fun getUserById(id: Int): Flow<User> {
        return userDao.getItem(id)
    }
}

