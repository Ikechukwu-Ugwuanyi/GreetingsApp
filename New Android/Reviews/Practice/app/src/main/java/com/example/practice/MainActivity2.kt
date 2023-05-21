package com.example.practice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener() {
//            val intent = Intent(this, MainActivity3::class.java)
//            intent.putExtra("name", 60)
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com"))

            startActivity(intent)
        }
    }



}