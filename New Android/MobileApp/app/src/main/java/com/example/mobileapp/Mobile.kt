package com.example.mobileapp

import android.util.Log

class Mobile(val battery: Battery, val simCard: Display, val display: SimCard) {

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