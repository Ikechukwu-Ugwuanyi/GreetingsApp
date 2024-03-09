package com.example.actorsapppracticde2.retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.actorsapppracticde2.retrofit.Characters
import com.example.actorsapppracticde2.retrofit.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(val characterRepo: CharacterRepository): ViewModel() {

    val _state = MutableStateFlow(emptyList<Characters>())
    val state: StateFlow<List<Characters>>
        get() = _state

    init {
        viewModelScope.launch {
            val charepo = characterRepo.getCharacters()
            _state.value = charepo
        }
    }
}