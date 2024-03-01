package com.example.libraryapppractice3.repository

import com.example.libraryapppractice3.room.LibraryDatabase
import com.example.libraryapppractice3.room.LibraryEntity

class LibraryRepository(private val bookDb: LibraryDatabase)  {

    suspend fun addBook(book: LibraryEntity){
        bookDb.bookDao().insertBook(book)
    }

    suspend fun update(book: LibraryEntity){
        bookDb.bookDao().updateBook(book)
    }

    suspend fun deleteBook(book: LibraryEntity){
        bookDb.bookDao().deleteBook(book)
    }

    val allBooks = bookDb.bookDao().getAllBooks()
}