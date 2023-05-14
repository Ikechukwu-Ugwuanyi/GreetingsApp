package com.example.vaccinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. AdapterView: RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        //2. Data Source: List Of VaccineModel Objects
        var vaccinesList : ArrayList<VaccineModel> = ArrayList()

        val v1 = VaccineModel("COVID19", R.drawable.vaccine1)
        val v2 = VaccineModel("Hepatitis-B Vaccine", R.drawable.vaccine2)
        val v3 = VaccineModel("Malaria Vaccine", R.drawable.vaccine3)
        val v4 = VaccineModel("Pneumonia Vaccine", R.drawable.vaccine4)
        val v5 = VaccineModel("HIV Vaccine", R.drawable.vaccine5)
        val v6 = VaccineModel("Tetanus vaccine", R.drawable.vaccine6)
        val v7 = VaccineModel("Rashes Vaccine", R.drawable.vaccine7)
        val v8 = VaccineModel("Boil vaccine", R.drawable.vaccine8)

        vaccinesList.add(v1)
        vaccinesList.add(v2)
        vaccinesList.add(v3)
        vaccinesList.add(v4)
        vaccinesList.add(v5)
        vaccinesList.add(v6)
        vaccinesList.add(v7)
        vaccinesList.add(v8)

        //3. Adapter
        val adapter = MyAdapter(vaccinesList)
        recyclerView.adapter = adapter

    }
}