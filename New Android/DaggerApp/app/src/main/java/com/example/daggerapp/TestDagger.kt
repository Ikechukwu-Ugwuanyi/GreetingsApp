package com.example.daggerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class TestDagger : AppCompatActivity() {

    @Inject
    private lateinit var mobile:Mobile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_dagger)

        //DaggerMobileComponent.create().getMobileInstance().turnOnMobile
        //DaggerMobileComponent.create()
            //.inject(this)

//        val mobile = Mobile(
//            Battery(),
//            SimCard(ServiceProvider()),
//            Display()
//        mobile.turnOnMobile()
//        )
    }


}