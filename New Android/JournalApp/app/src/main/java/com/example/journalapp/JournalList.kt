package com.example.journalapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.journalapp.databinding.ActivityJournalListBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference

class JournalList : AppCompatActivity() {
    lateinit var binding: ActivityJournalListBinding

    //Firebase Reference
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var user:FirebaseUser
    var db = FirebaseFirestore.getInstance()
    lateinit var storageReference: StorageReference
    var collectionReference = db.collection("Journal")

    lateinit var journalList: List<Journal>
    lateinit var adapter: JournalAdapter

    lateinit var noPostsText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_journal_list)

        //FirebaseAuth
        firebaseAuth = Firebase.auth
        user = firebaseAuth.currentUser!!

        //Recycler View Initialization
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //Posts arrayList
        journalList = arrayListOf<Journal>()

    }
}