package com.example.actorsapppractice.retrofit

import retrofit2.http.GET

interface CharacterApi {

    @GET
    suspend fun getCharacters(): List<Characters>
}