package com.example.practice2

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    val fragment_size = 3

    override fun getItemCount(): Int {
        return this.fragment_size
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> {
                return FragmentOne()
            }

            1 -> {
                return FragmentTwo()
            }

            2 -> {
                return FragmentThree()
            }
        }

        return FragmentOne()
    }
}