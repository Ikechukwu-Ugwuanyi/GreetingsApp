package com.example.viewsandwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.result_text)



        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener() {
            textView.setText(" "+ (counter++) * (counter++))        }

    }


}