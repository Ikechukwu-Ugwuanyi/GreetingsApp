package com.example.actorsapppracticde2.retrofit

import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getCharacters() : List<Characters>
}