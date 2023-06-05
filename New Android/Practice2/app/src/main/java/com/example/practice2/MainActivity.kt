package com.example.practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

   lateinit var adapter: MyAdapter
   lateinit var viewPager2: ViewPager2
   private val myArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.viewPager)
        adapter = MyAdapter(this)

        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewPager2.adapter = adapter





    }


}