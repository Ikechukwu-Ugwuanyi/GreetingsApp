package com.example.contactsmanagerpractice.main.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)
abstract class UserDb : RoomDatabase() {

    abstract val userDAO : UserDAO

    companion object {
        @Volatile
        var INSTANCE: UserDb ?= null
        fun getInstance(context: Context) : UserDb {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDb::class.java,
                        "User_db"
                    ).build()
                }
                return instance
            }
        }
    }

}