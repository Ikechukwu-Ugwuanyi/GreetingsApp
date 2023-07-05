package com.example.mobileapp

import android.util.Log
import javax.inject.Inject

class Display @Inject constructor(){

    init {
        Log.i("TAG", "Screen Created!")
    }

    fun turnOnScreen() {
        Log.i("TAG", "Turning on the screen")
    }
}