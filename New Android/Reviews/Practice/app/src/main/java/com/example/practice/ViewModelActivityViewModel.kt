package com.example.practice

import androidx.lifecycle.ViewModel

class ViewModelActivityViewModel : ViewModel() {

    private var counter = 0

    fun getCurrentCount() : Int {
        return counter
    }

    fun getUpdatedCount() :Int {
        return counter++
    }
}