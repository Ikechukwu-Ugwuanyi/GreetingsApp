package com.example.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "onCreate() is called", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(this, "onStart() is called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume() is called", Toast.LENGTH_SHORT).show()
    }
}