package com.example.mobileapp

import android.util.Log
import javax.inject.Inject

interface Display {

    fun turnOnScreen() {
        Log.i("TAG", "Turning on the screen")
    }
}