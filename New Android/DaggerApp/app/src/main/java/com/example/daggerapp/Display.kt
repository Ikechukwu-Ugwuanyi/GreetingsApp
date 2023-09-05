package com.example.daggerapp

import android.util.Log


interface Display {

    fun turnOnScreen() {
        Log.i("TAG", "Screen is turnedOn")
    }
}