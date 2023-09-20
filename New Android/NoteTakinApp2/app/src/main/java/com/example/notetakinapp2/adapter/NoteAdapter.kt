package com.example.notetakinapp2.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notetakinapp2.databinding.NoteLayoutBinding
import com.example.notetakinapp2.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemBinding: NoteLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteBody == newItem.noteBody &&
                    oldItem.noteTitle == newItem.noteBody
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            TODO("Not yet implemented")
        }

    }



}