package com.example.notetakinapp2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.notetakinapp2.R
import com.example.notetakinapp2.adapter.NoteAdapter
import com.example.notetakinapp2.databinding.FragmentNewNoteBinding
import com.example.notetakinapp2.model.Note
import com.example.notetakinapp2.viewModel.NoteViewModel


class NewNoteFragment : Fragment(R.layout.fragment_new_note) {

    private var _binding : FragmentNewNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var notesViewModel : NoteViewModel
    private lateinit var noteAdapter : NoteAdapter
    private lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = (activity as MainActivity).noteViewModel
        mView = view
    }

    private fun saveNote(view: View) {
        val noteTitle = binding.editNoteTitle.text.toString().trim()
        val noteBody = binding.editNoteBody.text.toString().trim()

        if(noteTitle.isNotEmpty()) {
            val note = Note(0, noteTitle, noteBody)

            notesViewModel.addNote(note)

            Toast.makeText(this, "Note Saved Successfully", Toast.LENGTH_LONG).show()

            view.findNavController().navigate(R.id.action_newNoteFragment_to_homeFragment)

        } else {
            Toast.makeText(this, "Please enter note title", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

        val mMenuSearch = menu.findItem(R.id.menu_search).actionView as SearchView
        mMenuSearch.isSubmitButtonEnabled = false
        mMenuSearch.setOnQueryTextListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}