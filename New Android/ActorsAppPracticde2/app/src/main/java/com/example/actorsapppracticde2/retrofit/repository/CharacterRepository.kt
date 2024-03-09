package com.example.actorsapppracticde2.retrofit.repository

import com.example.actorsapppracticde2.retrofit.Characters
import com.example.actorsapppracticde2.retrofit.CharacterApi

class CharacterRepository(val characterApi: CharacterApi) {

    suspend fun getCharacters() : List<Characters> {
        return characterApi.getCharacters()
    }

}