package com.example.dependencvyinjectionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val engine = Engine()
        val engine2 = Engine()
        val car = Car(engine2)
        car.start() 

    }




}