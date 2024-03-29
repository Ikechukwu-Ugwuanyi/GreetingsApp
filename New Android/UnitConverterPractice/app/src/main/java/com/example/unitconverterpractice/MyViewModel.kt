package com.example.unitconverterpractice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class MyViewModel : ViewModel() {

    var tempC by mutableIntStateOf(0)

    fun convertTemp(tempF: String){
        var tempFnum = tempF.toInt()

        tempC = ((tempFnum - 32 ) * 0.5556).roundToInt()
    }
}