package com.example.simplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1 - Adapter View
        var listView : ListView = findViewById(R.id.listView)

        //2 Data Source : Array of Strings
        var worldCupArray = arrayOf(
            "Germany", "Brazil", "England", "Spain","Qatar","Netherlands", "France", "Croatia", "Italy", "Uruguay", "Nigeria"
        )

        //3 - Adapter
        val arrayAdapter : ArrayAdapter<*>

        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            worldCupArray
        )

        listView.adapter = arrayAdapter

    }
}