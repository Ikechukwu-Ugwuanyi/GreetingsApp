package com.example.notetakinapp2.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notetakinapp2.model.Note

@Database(entities = [Note::class], version= 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao() : NoteDAO

    companion object{
        @Volatile
        private var instance: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK) {

        }
    }
}