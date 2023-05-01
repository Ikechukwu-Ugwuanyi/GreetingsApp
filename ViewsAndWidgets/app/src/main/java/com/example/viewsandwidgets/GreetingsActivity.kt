package com.example.viewsandwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class GreetingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greetins_app)

        val editText: EditText = findViewById(R.id.edit)
        val btn: Button = findViewById(R.id.btn)
        val enteredText = editText.text

        btn.setOnClickListener() {
            Toast.makeText(this, "Hello " + enteredText, Toast.LENGTH_LONG).show()
        }

    }
}