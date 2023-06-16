package com.example.notetakingapp.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notetakingapp.R
import com.example.notetakingapp.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}