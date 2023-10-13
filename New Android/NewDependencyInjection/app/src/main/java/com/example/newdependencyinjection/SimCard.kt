package com.example.newdependencyinjection

import android.util.Log
import javax.inject.Inject

class SimCard @Inject constructor (private val serviceProvider: ServiceProvider) {

    init {
        Log.i("TAG", "Sim Card Created")
    }

    fun connectToNetwork(){
        serviceProvider.getServiceProvider()
    }
}