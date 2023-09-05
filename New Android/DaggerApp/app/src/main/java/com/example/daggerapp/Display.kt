package com.example.daggerapp

import android.util.Log
import javax.inject.Inject

class Display @Inject constructor(){

    init {
        Log.i("TAG", "Display is turnedOn")
    }

    fun turnOnScreen() {
        Log.i("TAG", "Screen is turnedOn")
    }
}