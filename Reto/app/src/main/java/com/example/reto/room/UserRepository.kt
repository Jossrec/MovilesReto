package com.example.reto.room


import com.example.reto.model.User


class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}