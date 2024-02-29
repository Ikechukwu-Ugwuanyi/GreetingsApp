package com.example.libraryapppractice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BooKEntity::class], version = 1, exportSchema = false)
abstract class BookDB : RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {

        @Volatile
        private var INSTANCE: BookDB? = null

        fun getInstance(context: Context): BookDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BookDB::class.java,
                        "book_db2"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}