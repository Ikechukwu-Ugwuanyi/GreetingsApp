package com.example.firebaseapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)

        //Real Time database reference
        //https://fir-kotlin-5308f-default-rtdb.firebaseio.com/
        database = Firebase.database.reference

        //Writing custom objects to Firebase
        val user1 = User("John", "2345")
        database.child("Users").setValue(user1)

        //Reading custom objects from Firebase
        val pe = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val u1 = snapshot.getValue<User>()
                textView.text = u1.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }

        database.child("Users").addValueEventListener(pe)


        //Write data to firebase
        //database.child("price").setValue("$14980")

        //Reading from firebase
//        val postListener = object: ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val gold_price = snapshot.value
//
//                textView.text = gold_price.toString()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        }
//
//        database.child("price").addValueEventListener(postListener)

    }
}