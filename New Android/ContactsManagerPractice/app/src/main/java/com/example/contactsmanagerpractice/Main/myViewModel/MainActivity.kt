package com.example.contactsmanagerpractice.Main.myViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactsmanagerpractice.R
import com.example.contactsmanagerpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}