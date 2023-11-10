package com.example.quizapp.model

data class Questions(
    val correct_option: Int,
    val option1: Int,
    val option2: Int,
    val option3: Int,
    val option4: Int,
    val question: String
)