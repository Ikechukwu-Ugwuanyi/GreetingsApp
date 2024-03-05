package com.example.actorsapp.repository

import com.example.actorsapp.retrofit.CharacterApi
import com.example.actorsapp.retrofit.Characters

class CharacterRepo(private val characterApi: CharacterApi) {

    suspend fun getCharacters() : List<Characters>{
        return characterApi.getCharacters()
    }
}