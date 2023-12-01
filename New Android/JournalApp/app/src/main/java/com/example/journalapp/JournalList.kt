package com.example.journalapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
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

    lateinit var journalList: MutableList<Journal>
    lateinit var adapter: JournalAdapter

    lateinit var noPostsText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_journal_list)

        //FirebaseAuth
        firebaseAuth = Firebase.auth
        user = firebaseAuth.currentUser!!

        //Recycler View Initialization
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //Posts arrayList
        journalList = arrayListOf<Journal>()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.addJournal -> {
                if (user != null && firebaseAuth != null){
                    val intent = Intent(this, AddJournalActivity::class.java)
                    startActivity(intent)
                }
            }

            R.id.sign_out -> {
                if (user != null && firebaseAuth!= null) {
                    firebaseAuth.signOut()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //Getting all posts
    override fun onStart() {
        super.onStart()

        collectionReference.whereEqualTo("userId",
            JournalUser.instance?.userId)
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty){
                    it.forEach {

                    //convert snapshots to journal objects
                    var journal = it.toObject(Journal::class.java)
                    journalList.add(journal)
                    }

                    //RecyclerView
                    adapter = JournalAdapter(this, journalList)
                    binding.recyclerView.setAdapter(adapter)
                    adapter.notifyDataSetChanged()
                } else {
                    binding.noPostText.visibility = View.VISIBLE
                }

            }
            .addOnFailureListener {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
            }

    }

}