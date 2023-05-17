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

        val listView : ListView = findViewById(R.id.listView)

        val states = arrayListOf("Abuja", "Kogi", "Lagos", "Sokoto", "Enugu")

        val statesAdapter:BaseAdapter = ArrayAdapter(this, android.R.layout.simple_selectable_list_item, states)

        listView.adapter = statesAdapter






    }
}