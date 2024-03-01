package com.example.libraryapppractice3.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert
    suspend fun insertBook(book: LibraryEntity)

    @Update
    suspend fun updateBook(book: LibraryEntity)

    @Delete
    suspend fun deleteBook(book: LibraryEntity)

    @Query("SELECT * FROM LibraryEntity")
    fun getAllBooks(): Flow<List<LibraryEntity>>

}