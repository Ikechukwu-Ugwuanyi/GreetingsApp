package com.example.tablayoutapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayoutapp.Fragments.BridgeFragment
import com.example.tablayoutapp.Fragments.PictureFragment
import com.example.tablayoutapp.Fragments.SeaFragment

class MyAdapter(fragmentManager: FragmentManager, lifeCycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifeCycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return SeaFragment()


            1 -> return PictureFragment()


            2 -> return BridgeFragment()
        }

        return SeaFragment()
    }
}