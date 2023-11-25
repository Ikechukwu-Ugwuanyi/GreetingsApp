package com.example.firebaseapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FireStore : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_store)

        val db = Firebase.firestore

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

        db_collection.document("User1").set(user1)
        db_collection.document("User1").set(user2)


    }
}