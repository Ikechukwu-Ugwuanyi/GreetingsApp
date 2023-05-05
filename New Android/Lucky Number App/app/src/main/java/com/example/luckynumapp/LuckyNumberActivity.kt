package com.example.luckynumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val text1: TextView = findViewById(R.id.text1)
        val text2: TextView = findViewById(R.id.text2)
        val btn: Button = findViewById(R.id.button)
    }

    fun recieveUsername() : String{
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }
}