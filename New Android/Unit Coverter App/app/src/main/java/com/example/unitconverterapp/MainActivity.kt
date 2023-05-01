package com.example.unitconverterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText8)
        val btn = findViewById<Button>(R.id.btn)
        val textView = findViewById<TextView>(R.id.result_text)

        btn.setOnClickListener() {
            val kilos: Double = editText.text.toString().toDouble()
            textView.setText("" +convertToPounds(kilos)+ "\n Pounds")

        }

    }

    fun convertToPounds(kilos : Double) : Double {
        var pounds = kilos * 2.20462
        return pounds
    }
}