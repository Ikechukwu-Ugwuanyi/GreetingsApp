package com.example.practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val startingNum: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ViewModelActivityViewModel::class.java)) {
            return ViewModelActivityViewModel(startingNum) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }


}