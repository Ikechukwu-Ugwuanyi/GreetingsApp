package com.example.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text: TextView = findViewById(R.id.textView)
        val editText: TextView = findViewById(R.id.editText)
        val btnWish : Button = findViewById(R.id.btnWish)

        btnWish.setOnClickListener() {
            val name = editText.text
            val intent: Intent = Intent(this, LuckyNumberActivity::class.java)
            intent.putExtra("name", name)

            startActivity(intent)
        }




    }
}