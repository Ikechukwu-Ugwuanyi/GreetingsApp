package com.example.databinding


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.apply {
            btn.setOnClickListener() {
                intent = Intent(this@MainActivity, DataBindingObjects::class.java)
                startActivity(intent)
                val enteredText: String = editText.text.toString()
                textView.setText("Hello $enteredText")
            }
        }

    }
}