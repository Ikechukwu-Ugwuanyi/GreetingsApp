package com.example.notetakinapp2.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notetakinapp2.R
import com.example.notetakinapp2.viewModel.NoteViewModel

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}