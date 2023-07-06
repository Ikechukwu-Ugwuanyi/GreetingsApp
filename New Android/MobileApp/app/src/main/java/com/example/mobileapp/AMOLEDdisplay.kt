package com.example.mobileapp

import android.util.Log
import javax.inject.Inject

class AMOLEDdisplay @Inject constructor(): Display {
    override fun turnOnScreen() {
        Log.i("TAG", "Amoled display is created!")
    }

}