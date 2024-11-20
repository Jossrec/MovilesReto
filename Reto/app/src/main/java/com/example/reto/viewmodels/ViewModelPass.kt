package com.example.reto.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class SharedViewModel : ViewModel() {
    val email: MutableLiveData<String> = MutableLiveData("")
}