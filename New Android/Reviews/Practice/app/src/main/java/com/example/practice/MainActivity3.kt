package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val bundle: Bundle? = intent.extras
        val number = bundle?.get("name")

        Toast.makeText(this, "Your age is: $number", Toast.LENGTH_SHORT).show()
    }
}