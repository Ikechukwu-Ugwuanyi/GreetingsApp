package com.example.newdependencyinjection

import android.util.Log

class Mobile(val battery: Battery, val simCard: SimCard, val display: Display ) {

    init {
        battery.displayBatteryPower()
        simCard.connectToNetwork()
        display.turnOnScreen()

        Log.i("TAG", "Mobile is created successfully")
    }

    fun turnOnMobile(){
        Log.i("TAG", "Mobile is turned on.")
    }
}