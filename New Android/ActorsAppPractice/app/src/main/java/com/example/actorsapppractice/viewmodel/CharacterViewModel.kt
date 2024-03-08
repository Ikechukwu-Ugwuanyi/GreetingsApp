package com.example.actorsapppractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.actorsapppractice.repository.CharacterRepository
import com.example.actorsapppractice.retrofit.Characters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(val characterRepo: CharacterRepository) : ViewModel() {

   var _state = MutableStateFlow(emptyList<Characters>())
    val state : StateFlow<List<Characters>>
        get() = _state

    init {
        viewModelScope.launch {
            val charepo = characterRepo.getCharacters()
            _state.value = charepo
        }
    }
}