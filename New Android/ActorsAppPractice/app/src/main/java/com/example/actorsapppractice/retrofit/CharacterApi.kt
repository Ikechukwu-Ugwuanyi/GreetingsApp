package com.example.actorsapppractice.retrofit

import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getCharacters(): List<Characters>
}