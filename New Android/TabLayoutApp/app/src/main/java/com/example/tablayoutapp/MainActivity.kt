package com.example.tablayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayoutapp.Adapter.MyAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    val tabsArray = arrayOf("Sea", "Picture","Bridge")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabView)

        val adapter = MyAdapter(supportFragmentManager, lifecycle)

        viewPager.adapter = adapter
    }
}