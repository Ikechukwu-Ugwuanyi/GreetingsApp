package com.example.mobileapp

import android.util.Log
import javax.inject.Inject

class Mobile @Inject constructor(val battery: Battery, val simCard: SimCard, val display: Display) {

    init {
        battery.displayBatterPower()
        simCard.connectToNetwork()
        display.turnOnScreen()

        Log.i("TAG", "Mobile is created successfully!")
    }

    fun turnOnMobile() {
        Log.i("TAG", "Mobile is created successfully!")
    }
}