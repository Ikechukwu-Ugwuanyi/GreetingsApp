package com.example.daggerapp

import android.util.Log

class ServiceProvider {
    init {
        Log.i("TAG", "Sim is Created")
    }

    fun getServiceProvider() {
        Log.i("TAG", "Service Provider is on")
    }
}