package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val battery = Battery()
        val display = Display()
        val serviceProvider = ServiceProvider()
        val simCard = SimCard(serviceProvider)

        val mobile = Mobile(battery, simCard, display)
        mobile.turnOnMobile()
    }
}