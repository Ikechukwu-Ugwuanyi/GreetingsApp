package com.example.daggerapp

import android.util.Log
import javax.inject.Inject

class SimCard @Inject constructor(private val serviceProvider: ServiceProvider) {

    init {
        Log.i("TAG", "Sim is Created")
    }

    fun connectToNetwork() {
        serviceProvider.getServiceProvider()
    }
}