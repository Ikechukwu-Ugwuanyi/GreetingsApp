package com.example.daggerapp

import android.util.Log
import javax.inject.Inject


class Mobile @Inject constructor (val battery: Battery, val simCard : SimCard, val display: Display) {

    init{
        battery.displayBatteryPower()
        simCard.connectToNetwork()
        display.turnOnScreen()

        Log.i("TAG", "Mobile is created Successfully")
    }

    fun turnOnMobile() {
        Log.i("TAG", "Mobile is turned on!")
    }

}