package com.example.libraryapppractice3.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LibraryEntity::class], version = 1, exportSchema = false)
abstract class LibraryDatabase : RoomDatabase() {

    abstract  fun bookDao() : BookDao

    companion object {

        @Volatile
        var INSTANCE : LibraryDatabase? = null

        fun getInstance(context: Context): LibraryDatabase {
            var instance = INSTANCE
            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibraryDatabase::class.java,
                    "libarary_db"
                ).build()
                INSTANCE = instance
            }
            return instance
        }
    }

}