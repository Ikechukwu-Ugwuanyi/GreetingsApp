package com.example.newdependencyinjection

import android.util.Log

class Display {
    init {
        Log.i("TAG", "Screen Created")
    }

    fun turnOnScreen(){
        Log.i("TAG", "Turning ON the Screen")
    }
}