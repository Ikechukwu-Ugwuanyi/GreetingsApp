package com.example.newdependencyinjection

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {
    init {
        Log.i("TAG", "Service Provider Created")
    }

    fun getServiceProvider(){
        Log.i("TAG", "Service Created")
    }
}