package com.example.libraryapppractice.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert
    suspend fun addBook(booKEntity: BooKEntity)

    @Update
    suspend fun updateBook(booKEntity: BooKEntity)

    @Delete
    suspend fun deleteBook(booKEntity: BooKEntity)

    @Query("SELECT * FROM BooKEntity")
    fun getAllBooks() : Flow<List<BooKEntity>>
}