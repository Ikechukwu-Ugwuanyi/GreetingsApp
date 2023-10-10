package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SequentialParallelCoroutine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sequential_parallel_coroutine)

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("TAG", "The app is started!")
            val one = async {
                doSomethingUseful1()
            }
            val two = async {
                doSomethingUseful2()
            }

            val result = one.await() + two.await()
            Log.i("TAG", "The result is $result")
        }

    }

    suspend fun doSomethingUseful1() : Int {
        delay(10000)
        Log.i("TAG", "The number 1 is 12")
        return 12
    }

    suspend fun doSomethingUseful2() : Int {
        delay(7000)
        Log.i("TAG", "The number 2 is 10")
        return 10
    }

}