package com.example.viewpager.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager.Fragments.Fragment2
import com.example.viewpager.Fragments.Fragment3
import com.example.viewpager.Fragments.FragmentOne
import com.example.viewpager.MainActivity

class MyAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    private val Fragments_Size = 3
    override fun getItemCount(): Int  {
        return this.Fragments_Size
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return FragmentOne()
            }

            1 -> {
                return Fragment2()
            }

            2 -> {
                return Fragment3()
            }
        }

        return FragmentOne()
    }
}