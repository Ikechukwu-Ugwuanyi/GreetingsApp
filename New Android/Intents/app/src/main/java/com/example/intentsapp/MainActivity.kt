package com.example.intentsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn : Button = findViewById(R.id.btn)
        val btn2  = findViewById<Button>(R.id.btnimp)

        btn.setOnClickListener() {

            //Explicit Itents
            var intent : Intent = Intent(this, Activity2::class.java)
            intent.putExtra("age", 27)

            startActivity(intent)


        }

        btn2.setOnClickListener() {

            //Explicit Itents
            var intent : Intent = Intent(this, ImplicitActivity::class.java)
            startActivity(intent)


        }
    }
}