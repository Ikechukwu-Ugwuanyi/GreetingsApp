package com.example.firebaseapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FireStore : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_store)

        val db = Firebase.firestore

        val textView = findViewById<TextView>(R.id.textView2)

        //Creating a collection of Users
        val db_collection = db.collection("Users")

        //Creating a user
        val user1 = hashMapOf(
            "name" to "Frank",
            "age" to 65,
            "country" to "Germany"
        )

        val user2 = hashMapOf(
            "name" to "James",
            "age" to 60,
            "country" to "France"
        )

        //Recieving documents from Firestore
        db_collection.document("User1").set(user1)
        db_collection.document("User2").set(user2)

        val docRef = db.collection("Users").document("User1")

        docRef.get().addOnSuccessListener { document ->
            if (document != null){
                textView.text = document.data?.get("name").toString()
            }
        }

    }
}