package com.example.newdependencyinjection

import android.util.Log

class ServiceProvider {
    init {
        Log.i("TAG", "Battery Created")
    }

    fun getServiceProvider(){
        Log.i("TAG", "Service Provider Created")
    }
}