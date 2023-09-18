package com.example.notetakinapp2.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetakinapp2.model.Note
import com.example.notetakinapp2.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val repository: NoteRepository) : AndroidViewModel(app) {

    suspend fun addNote(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }

    suspend fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }

    suspend fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }

    fun getNotes(note: Note) = repository.getAllNotes()
    fun searchNote(query: String?) = repository.searchNote(query)
}