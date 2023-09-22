package com.example.notetakinapp2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.notetakinapp2.R
import com.example.notetakinapp2.adapter.NoteAdapter
import com.example.notetakinapp2.databinding.FragmentHomeBinding
import com.example.notetakinapp2.viewModel.NoteViewModel


class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var notesViewModel : NoteViewModel
    private lateinit var adapter : NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notesViewModel = (activity as MainActivity).notesViewModel

        setUpRecyclerView()
        binding.fabAddNote.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_homeFragment_to_newNoteFragment
            )
        }
    }

    private fun setUpRecyclerView() {
        TODO("Not yet implemented")
    }

}