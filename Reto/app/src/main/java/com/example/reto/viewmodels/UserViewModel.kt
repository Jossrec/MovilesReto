package com.example.reto.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reto.model.User
import com.example.reto.room.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun registerUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            val user = User(name = name, email = email, password = password)
            repository.insertUser(user)
        }
    }

}