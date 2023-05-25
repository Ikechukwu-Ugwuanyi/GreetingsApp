package com.example.sharedpreferencesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val btn: Button = findViewById(R.id.saveBtn)

        btn.setOnClickListener() {
            val enteredText : String = editText.text.toString()
        }
    }
}