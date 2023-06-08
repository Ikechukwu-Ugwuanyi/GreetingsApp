package com.example.practice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel(startingNum : Int) : ViewModel() {

    private var total = MutableLiveData<Int>()
    val totalSum : LiveData<Int>
    get() = total

    fun sumUp(input: Int) {
        total.value = (total.value)?.plus(input)
    }



}