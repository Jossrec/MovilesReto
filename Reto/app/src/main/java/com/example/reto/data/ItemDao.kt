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

@Dao
interface ItemDao4 {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Formulario_6)

    @Update
    suspend fun update(item: Formulario_6)

    @Delete
    suspend fun delete(item: Formulario_6)

    @Query("SELECT * from formularios_6 WHERE id = :id")
    fun getItem(id: Int): Flow<Formulario_6>

    @Query("SELECT * from formularios_6 ORDER BY nombreCamara ASC")
    fun getAllItems(): Flow<List<Formulario_6>>
}

@Dao
interface ItemDao5 {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Formulario_5)

    @Update
    suspend fun update(item: Formulario_5)

    @Delete
    suspend fun delete(item: Formulario_5)

    @Query("SELECT * from formularios_5 WHERE id = :id")
    fun getItem(id: Int): Flow<Formulario_5>

    @Query("SELECT * from formularios_5 ORDER BY codigo ASC")
    fun getAllItems(): Flow<List<Formulario_5>>
}

@Dao
interface ItemDao6 {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Formulario_4)

    @Update
    suspend fun update(item: Formulario_4)

    @Delete
    suspend fun delete(item: Formulario_4)

    @Query("SELECT * from formularios_4 WHERE id = :id")
    fun getItem(id: Int): Flow<Formulario_4>

    @Query("SELECT * from formularios_4 ORDER BY codigo ASC")
    fun getAllItems(): Flow<List<Formulario_4>>
}

@Dao
interface ItemDao7 {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Formulario_3)

    @Update
    suspend fun update(item: Formulario_3)

    @Delete
    suspend fun delete(item: Formulario_3)

    @Query("SELECT * from formularios_3 WHERE id = :id")
    fun getItem(id: Int): Flow<Formulario_3>

    @Query("SELECT * from formularios_3 ORDER BY zona ASC")
    fun getAllItems(): Flow<List<Formulario_3>>
}

@Dao
interface ItemDao8 {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Formulario_1)

    @Update
    suspend fun update(item: Formulario_1)

    @Delete
    suspend fun delete(item: Formulario_1)

    @Query("SELECT * from formularios_1 WHERE id = :id")
    fun getItem(id: Int): Flow<Formulario_1>

    @Query("SELECT * from formularios_1 ORDER BY tipoAnimal ASC")
    fun getAllItems(): Flow<List<Formulario_1>>
}

