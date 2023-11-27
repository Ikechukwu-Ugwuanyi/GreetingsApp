package com.example.journalapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.journalapp.databinding.ActivityJournalListBinding

class JournalList : AppCompatActivity() {
    lateinit var binding: ActivityJournalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_journal_list)
    }
}