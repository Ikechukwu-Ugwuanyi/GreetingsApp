package com.example.composepromoapp

import androidx.annotation.DrawableRes

data class Courses(
    val rating: Float,
    val title : String,
    @DrawableRes val img: Int,
    val body: String
)

val course1 = Courses(
    3.2f,
    ""
)
