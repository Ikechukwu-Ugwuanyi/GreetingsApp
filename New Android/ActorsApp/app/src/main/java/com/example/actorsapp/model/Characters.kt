package com.example.actorsapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Characters(
    @Json(name = "actor")
    val actor: String,
    @Json(name ="image")
    val image: String
)
