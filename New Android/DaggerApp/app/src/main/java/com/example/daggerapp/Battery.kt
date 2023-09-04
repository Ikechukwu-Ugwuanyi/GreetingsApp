package com.example.daggerapp

import android.util.Log
import javax.inject.Inject

class Battery @Inject constructor(){
        init {
            Log.i("TAG", "Battery is turned on")
        }

    fun displayBatteryPower() {
        Log.i("TAG", "Battery Power on")
    }
}