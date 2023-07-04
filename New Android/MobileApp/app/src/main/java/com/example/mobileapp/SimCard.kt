package com.example.mobileapp

import android.util.Log

class SimCard(private val serviceProvider: ServiceProvider) {

    init {
        Log.i("TAG", "Sim card Created!")
    }

    fun connectToNetwork() {
        serviceProvider.getServiceProvider()
    }
}