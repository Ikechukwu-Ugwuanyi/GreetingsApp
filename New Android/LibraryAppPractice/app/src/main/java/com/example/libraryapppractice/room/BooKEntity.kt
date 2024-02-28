package com.example.libraryapppractice.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BooKEntity(
    @PrimaryKey(autoGenerate = true)
    val bookId: Int,
    val bookTitle: String
)