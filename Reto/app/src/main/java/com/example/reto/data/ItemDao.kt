package com.example.reto.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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
    suspend fun insert(item: Formulario7)

    @Update
    suspend fun update(item: Formulario7)

    @Delete
    suspend fun delete(item: Formulario7)

    @Query("SELECT * from formulario_tipo_7 WHERE id = :id")
    fun getItem(id: Int): Flow<Formulario7>

    @Query("SELECT * from formulario_tipo_7 ORDER BY localidad ASC")
    fun getAllItems(): Flow<List<Formulario7>>
}