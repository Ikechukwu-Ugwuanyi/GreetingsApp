package com.example.libraryapppractice.repository

import com.example.libraryapppractice.room.BooKEntity
import com.example.libraryapppractice.room.BookDB

class BookRepository(private val booksDB: BookDB) {

    suspend fun addBook(booKEntity: BooKEntity){
        booksDB.bookDao().addBook(booKEntity)
    }

    suspend fun updateBook(booKEntity: BooKEntity){
        booksDB.bookDao().updateBook(booKEntity)
    }

    suspend fun deleteBook(booKEntity: BooKEntity){
        booksDB.bookDao().deleteBook(booKEntity)
    }

    val getAllBooks = booksDB.bookDao().getAllBooks()
}