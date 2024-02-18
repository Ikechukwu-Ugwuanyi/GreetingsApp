package com.example.libraryapp.repository

import com.example.libraryapp.room.BookDatabase
import com.example.libraryapp.room.BookEntity

class BookRepository(val bookDatabase: BookDatabase) {

    suspend fun addBookToRoom(bookEntity: BookEntity) {
        bookDatabase.bookDao().addBook(bookEntity)
    }

}