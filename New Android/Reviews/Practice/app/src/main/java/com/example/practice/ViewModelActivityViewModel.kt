package com.example.practice

import androidx.lifecycle.ViewModel

class ViewModelActivityViewModel(startingNum: Int) : ViewModel() {

    private var counter = 0

    fun getCurrentCount() : Int {
        return counter
    }

    fun getUpdatedCount() :Int {
        return ++counter
    }
}