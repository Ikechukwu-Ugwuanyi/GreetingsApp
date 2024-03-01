package com.example.libraryapppractice3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libraryapppractice3.repository.LibraryRepository
import com.example.libraryapppractice3.room.LibraryEntity
import kotlinx.coroutines.launch

class LibraryViewModel(private val repository: LibraryRepository) : ViewModel() {

    fun addBook(book: LibraryEntity){
        viewModelScope.launch {
            repository.addBook(book)
        }
    }

    fun update(book: LibraryEntity){
        viewModelScope.launch {
            repository.update(book)
        }
    }

    fun deleteBook(book: LibraryEntity){
        viewModelScope.launch {
            repository.deleteBook(book)
        }
    }

    val allBooks = repository.allBooks

}