package com.example.newdependencyinjection

import android.util.Log

class SimCard(private val serviceProvider: ServiceProvider) {

    init {
        Log.i("TAG", "Sim Card Created")
    }

    fun connectToNetwork(){
        serviceProvider.getServiceProvider()
    }
}