/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.reto.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

/**
 * Entity data class represents a single row in the database.
 */
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val email: String,
    val contraseña: String
)

data class Formulario(
    @Embedded val formularioBase: Formulario_base,
    @Relation(
        parentColumn = "id",
        entityColumn = "formId"
    )
    val ventanasB: Formulario_7
    //val ventanasB: val ventanasB: Formulario_7
)

@Entity(tableName = "formularios_base")
data class Formulario_base(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val fecha: String,
    val Localidad: String,
    val Hora: String,
    val Estado_del_Tiempo: String,
    val Época: String,
    val Tipo_Registro: String
)

@Entity(
    tableName = "formularios_7",
    foreignKeys = [
        ForeignKey(
            entity = Formulario_base::class,
            parentColumns = ["id"],
            childColumns = ["formId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["formId"])]  // Esto ayuda a optimizar las búsquedas por la clave foránea
)

data class Formulario_7(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val formId: Int,
    val zona: String,
    val Pluviosidad: String,
    val Temperatura_maxima: String,
    val Humedad_maxima: String,
    val Temperatura_minima: String,
    val Humedad_minima: String,
    val Nivel_Quebrada: String
)

@Entity(
    tableName = "formularios_6",
    foreignKeys = [
        ForeignKey(
            entity = Formulario_base::class,
            parentColumns = ["id"],
            childColumns = ["formId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["formId"])]  // Esto ayuda a optimizar las búsquedas por la clave foránea
)

data class Formulario_6(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val formId: Int,
    val codigo: String,
    val zona: String,
    val nombreCamara: String,
    val placaCamara: String,
    val placaGuaya: String,
    val anchoCamino: String,
    val fechaInstalacion: String,
    val alturaLente: String,
    val chequeo: List<Int>,
    val observaciones: String
)

data class Formulario_5(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val formId: Int,
    val codigo: String,
    val zona: String,
    val nombreCamara: String,
    val placaCamara: String,
    val placaGuaya: String,
    val anchoCamino: String,
    val fechaInstalacion: String,
    val alturaLente: String,
    val chequeo: List<Int>,
    val observaciones: String
)

data class Formulario_4(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val formId: Int,
    val codigo: String,
    val zona: String,
    val nombreCamara: String,
    val placaCamara: String,
    val placaGuaya: String,
    val anchoCamino: String,
    val fechaInstalacion: String,
    val alturaLente: String,
    val chequeo: List<Int>,
    val observaciones: String
)

data class Formulario_3(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val formId: Int,
    val codigo: String,
    val zona: String,
    val nombreCamara: String,
    val placaCamara: String,
    val placaGuaya: String,
    val anchoCamino: String,
    val fechaInstalacion: String,
    val alturaLente: String,
    val chequeo: List<Int>,
    val observaciones: String
)

data class Formulario_2(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val formId: Int,
    val codigo: String,
    val zona: String,
    val nombreCamara: String,
    val placaCamara: String,
    val placaGuaya: String,
    val anchoCamino: String,
    val fechaInstalacion: String,
    val alturaLente: String,
    val chequeo: List<Int>,
    val observaciones: String
)

data class Formulario_1(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val formId: Int,
    val codigo: String,
    val zona: String,
    val nombreCamara: String,
    val placaCamara: String,
    val placaGuaya: String,
    val anchoCamino: String,
    val fechaInstalacion: String,
    val alturaLente: String,
    val chequeo: List<Int>,
    val observaciones: String
)
