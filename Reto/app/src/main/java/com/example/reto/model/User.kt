package com.example.reto.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val email: String,  // email como clave primaria
    val password: String            // Contraseña asociada
)
