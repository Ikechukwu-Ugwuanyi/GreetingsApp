package com.example.daggerapp

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor(){
    init {
        Log.i("TAG", "Sim is Created")
    }

    fun getServiceProvider() {
        Log.i("TAG", "Service Provider is on")
    }
}