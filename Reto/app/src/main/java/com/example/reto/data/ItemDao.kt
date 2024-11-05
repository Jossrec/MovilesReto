package com.example.reto.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from items ORDER BY nombre ASC")
    fun getAllItems(): Flow<List<Item>>
}

@Dao
interface ItemDao2 {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Formulario_base)

    @Update
    suspend fun update(item: Formulario_base)

    @Delete
    suspend fun delete(item: Formulario_base)

    @Query("SELECT id FROM formularios_base ORDER BY id DESC LIMIT 1")
    suspend fun getLastFormularioBaseId(): Int?

    @Query("SELECT * from formularios_base WHERE id = :id")
    fun getItem(id: Int): Flow<Formulario_base>

    @Query("SELECT * from formularios_base ORDER BY localidad ASC")
    fun getAllItems(): Flow<List<Formulario_base>>
}

@Dao
interface ItemDao3 {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Formulario_7)

    @Update
    suspend fun update(item: Formulario_7)

    @Delete
    suspend fun delete(item: Formulario_7)

    @Query("SELECT * from formularios_7 WHERE id = :id")
    fun getItem(id: Int): Flow<Formulario_7>

    @Query("SELECT * from formularios_7 ORDER BY Pluviosidad ASC")
    fun getAllItems(): Flow<List<Formulario_7>>
}

