package com.example.practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

   //lateinit var adapter: MyAdapter
   //lateinit var viewPager2: ViewPager2
   //private val myArray = ArrayList<String>()

    private val tabsArray = arrayOf("Ship Cruise", "New York City", "Rocks")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //View Pager
        /*

        viewPager2 = findViewById(R.id.viewPager)
        adapter = MyAdapter(this)

        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewPager2.adapter = adapter

         */

        //Tabs Layout

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabsLayout)

        val adapter: MyAdapter = MyAdapter(supportFragmentManager, lifecycle)

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) {
            tab, position -> tab.text = tabsArray[position]
        }.attach()

    }


}