package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val editText:EditText = findViewById(R.id.editText)
        val btn:Button = findViewById(R.id.btn)

        btn.setOnClickListener() {
            val enteredText: String = editText.text.toString()
            textView.setText("Hello $enteredText")
        }

    }
}