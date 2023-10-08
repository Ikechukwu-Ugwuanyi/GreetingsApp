package com.example.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapp.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}