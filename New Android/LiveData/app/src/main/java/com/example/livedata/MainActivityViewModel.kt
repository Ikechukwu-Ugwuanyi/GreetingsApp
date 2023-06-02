package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startTingNum: Int): ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalSum: LiveData<Int>
    get() = total

    init {
        total.value = startTingNum
    }

    fun setUp(input: Int) {
        total.value = (total.value)?.plus(input)
    }
}