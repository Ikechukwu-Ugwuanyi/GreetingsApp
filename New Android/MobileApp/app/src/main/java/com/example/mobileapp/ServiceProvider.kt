package com.example.mobileapp

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor(){

    init {
        Log.i("TAG", "ServiceProvider created!")
    }

    fun getServiceProvider() {
        Log.i("TAG", "ServiceProvider Created Successfully!" +
                "")
    }
}