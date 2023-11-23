package com.example.firebaseapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Real Time database reference
        //https://fir-kotlin-5308f-default-rtdb.firebaseio.com/
        database = Firebase.database.reference

        //Write data to firebase
        database.child("price").setValue("$1890")

    }
}