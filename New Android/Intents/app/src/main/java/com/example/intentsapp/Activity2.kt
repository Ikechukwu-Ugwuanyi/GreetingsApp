package com.example.intentsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        //var age: Bundle? = intent.getBundleExtra("age")
        val bundle: Bundle? = intent.extras
        val age = bundle?.get("age")


        Toast.makeText(this, "Your age is: " + age, Toast.LENGTH_SHORT).show()
    }
}