package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var mobile: Mobile
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val battery = Battery()
//        val display = Display()
//        val serviceProvider = ServiceProvider()
//        val simCard = SimCard(serviceProvider)


//        val simCard = SimCard()
//        simCard.serviceProvider = ServiceProvider()


//        val mobile = Mobile(Battery(),
//            simCard,
//            Display())
//        mobile.turnOnMobile()
    }
}