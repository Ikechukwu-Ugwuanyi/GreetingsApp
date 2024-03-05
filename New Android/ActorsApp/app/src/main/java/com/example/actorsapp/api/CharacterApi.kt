package com.example.actorsapp.api

import com.example.actorsapp.model.Characters
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getCharacters() : List<Characters>
}