package com.example.worldcupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1- Adapter View: ListView
        var listView = findViewById<ListView>(R.id.listView)

        //2- Adapter
        var adapter = MyAdapter(this, generateData())
        listView.adapter = adapter
        adapter?.notifyDataSetChanged()

    }

    //Data Source
     fun generateData(): ArrayList<CountryModal> {

         var countryList = ArrayList<CountryModal>()


        var country1: CountryModal = CountryModal(
            "Brazil",
            "5",
            R.drawable.brazil
        )

        var country2: CountryModal = CountryModal(
            "Germany",
            "4",
            R.drawable.germany
        )

        var country3: CountryModal = CountryModal(
            "Italy",
            "4",
            R.drawable.italy
        )

        var country4: CountryModal = CountryModal(
            "Spain",
            "1",
            R.drawable.spain
        )

        var country5: CountryModal = CountryModal(
            "Argentina",
            "3",
            R.drawable.argentina
        )

        var country6: CountryModal = CountryModal(
            "Uruguay",
            "2",
            R.drawable.uruguay
        )

        var country7: CountryModal = CountryModal(
            "England",
            "1",
            R.drawable.england
        )

        var country8: CountryModal = CountryModal(
            "Spain",
            "1",
            R.drawable.spain
        )

        var country9: CountryModal = CountryModal(
            "Argentina",
            "3",
            R.drawable.argentina
        )

        countryList.add(country1)
        countryList.add(country2)
        countryList.add(country3)
        countryList.add(country4)
        countryList.add(country5)
        countryList.add(country6)
        countryList.add(country7)
        countryList.add(country8)
        countryList.add(country9)

        return  countryList

     }


}