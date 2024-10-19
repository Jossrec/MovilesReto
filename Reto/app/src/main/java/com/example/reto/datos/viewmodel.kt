package com.example.reto.datos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import androidx.lifecycle.asLiveData


class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun insert(user: User) {
        viewModelScope.launch {
            repository.insert(user)
        }
    }

    fun getUserById(id: Int) = repository.getUserById(id).asLiveData() // Convierte Flow a LiveData
}

