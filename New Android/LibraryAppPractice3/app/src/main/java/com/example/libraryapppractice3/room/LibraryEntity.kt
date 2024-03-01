package com.example.libraryapppractice3.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LibraryEntity (
    @PrimaryKey(autoGenerate = true)
    val bookId: Int,
    val bookName: String
)