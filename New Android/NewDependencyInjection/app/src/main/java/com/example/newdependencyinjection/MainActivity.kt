package com.example.newdependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val battery = Battery()
        val serviceProvider = ServiceProvider()
        val display = Display()
        val simCard = SimCard(serviceProvider)

        val mobile = Mobile(battery, simCard, display)
        mobile.turnOnMobile()
    }
}