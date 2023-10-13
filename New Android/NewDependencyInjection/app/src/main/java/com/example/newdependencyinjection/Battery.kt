package com.example.newdependencyinjection

import android.util.Log
import javax.inject.Inject

class Battery @Inject constructor(){

    init {
        Log.i("TAG", "Battery Created")
    }

    fun displayBatteryPower(){
        Log.i("TAG", "Battery is on")
    }
}