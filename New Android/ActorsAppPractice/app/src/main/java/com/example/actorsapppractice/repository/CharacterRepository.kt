package com.example.actorsapppractice.repository

import com.example.actorsapppractice.retrofit.CharacterApi
import com.example.actorsapppractice.retrofit.Characters

class CharacterRepository(val characterApi: CharacterApi) {

    suspend fun getCharacters(): List<Characters> {
        return characterApi.getCharacters()
    }
}