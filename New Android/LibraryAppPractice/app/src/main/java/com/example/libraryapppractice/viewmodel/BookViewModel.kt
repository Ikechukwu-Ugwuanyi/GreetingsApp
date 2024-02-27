package com.example.libraryapppractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libraryapppractice.repository.BookRepository
import com.example.libraryapppractice.room.BooKEntity
import kotlinx.coroutines.launch

class BookViewModel(private val bookRepository: BookRepository) : ViewModel() {

    fun addBook(booKEntity: BooKEntity){
        viewModelScope.launch {
            bookRepository.addBook(booKEntity)
        }
    }

    fun updateBook(booKEntity: BooKEntity){
        viewModelScope.launch {
            bookRepository.updateBook(booKEntity)
        }
    }

    fun deleteBook(booKEntity: BooKEntity){
        viewModelScope.launch {
            bookRepository.deleteBook(booKEntity)
        }
    }

    val getAllBooks = bookRepository.getAllBooks


}