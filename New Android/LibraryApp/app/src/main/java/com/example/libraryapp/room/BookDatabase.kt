package com.example.libraryapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BookEntity::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDAO

    companion object {

        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getInstance(context: Context): BookDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BookDatabase::class.java,
                        "book_db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }
}