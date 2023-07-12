package com.example.mobileapp

import android.util.Log
import javax.inject.Inject

class Battery {

    init {
        Log.i("TAG", "Battery Created")
    }
    fun displayBatterPower() {
        Log.i("TAG", "Battery is 100%")
    }
}