package com.example.lessonreviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)

        val states : ArrayList<*> = arrayListOf("Kano", "Lagos", "Abuja", "Sokoto", "Jos", "Enugu ")

        val adapter : BaseAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, states)

        listView.adapter = adapter




    }
}