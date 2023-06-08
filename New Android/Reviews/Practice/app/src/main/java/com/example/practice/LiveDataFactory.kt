package com.example.practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LiveDataFactory(private val startingNum: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LiveDataViewModel::class.java)) {
            return LiveDataViewModel(startingNum) as T
        }

        throw  IllegalArgumentException("Unknown class")
    }

}