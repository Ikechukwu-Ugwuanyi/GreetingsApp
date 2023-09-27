package com.example.notetakinapp2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notetakinapp2.R
import com.example.notetakinapp2.databinding.FragmentUpdateNoteBinding
import com.example.notetakinapp2.model.Note
import com.example.notetakinapp2.viewModel.NoteViewModel

class UpdateNoteFragment : Fragment(R.layout.fragment_update_note) {

    private var _binding : FragmentUpdateNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var notesViewModel : NoteViewModel

    private lateinit var currentNote : Note

    //Since Update Note Fragment contains arguments in nav_graph
    private val args: UpdateNoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = (activity as MainActivity).noteViewModel
        currentNote = args.note

        binding.editNoteBodyUpdate.setText(currentNote.noteBody)
        binding.editNoteTitleUpdate.setText(currentNote.noteTitle)

        //if user updates note
        binding.floatingActionDone.setOnClickListener {
            val title = binding.editNoteTitleUpdate.text.toString().trim()
            val body = binding.editNoteBodyUpdate.text.toString().trim()

            if(title.isNotEmpty()) {
                val note = Note(currentNote.id, title, body)
                notesViewModel.updateNote(note)
                it.findNavController().navigate(R.id.action_updateNoteFragment_to_homeFragment)
            } else {
                Toast.makeText(context,
                    "Please enter note Title",
                    Toast.LENGTH_LONG).show()
            }
        }

    }

}