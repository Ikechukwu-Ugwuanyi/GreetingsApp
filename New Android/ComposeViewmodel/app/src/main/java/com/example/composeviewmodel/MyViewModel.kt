package com.example.composeviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel() : ViewModel(){
    var counter by  mutableStateOf(0)

    fun increaseCounter(){

        counter++
    }


}
