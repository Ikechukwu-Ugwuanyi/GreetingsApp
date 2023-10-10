package com.example.noteapp.repository

import com.example.noteapp.model.Note
import com.example.noteapp.model.NoteDatabase

class NoteRepository(private val db: NoteDatabase) {

    suspend fun insertNote(note: Note) = db.getNoteDAO().insertNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDAO().updateNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDAO().deleteNote(note)

    fun getAllNote() = db.getNoteDAO().getAllNotes()
    fun searchNote(query: String?) = db.getNoteDAO().searchNote(query)
}