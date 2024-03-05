package com.example.actorsapp.retrofit

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Characters(
    @Json(name = "actor")
    val actor: String,
    @Json(name ="image")
    val image: String
)
