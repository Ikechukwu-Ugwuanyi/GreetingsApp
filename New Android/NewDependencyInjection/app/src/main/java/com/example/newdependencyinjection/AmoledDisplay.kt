package com.example.newdependencyinjection

import android.util.Log
import javax.inject.Inject

class AmoledDisplay @Inject constructor() : Display{

    override fun turnOnScreen() {
            Log.i("TAG", "Turning ON the Screen")
    }
}