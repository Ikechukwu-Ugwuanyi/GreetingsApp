package com.example.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.model.NoteDatabase
import com.example.noteapp.repository.NoteRepository
import com.example.noteapp.viewmodel.NoteViewModel
import com.example.noteapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpVieModel()
    }

    private fun setUpVieModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val vieModelFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, vieModelFactory).get(NoteViewModel::class.java)
    }
}