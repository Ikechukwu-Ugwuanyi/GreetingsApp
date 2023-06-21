package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SequentialParallelCoroutine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sequential_parallel_coroutine)

        fun main() {
            CoroutineScope(Dispatchers.Main).launch {
                val one = doSomethingUseful1()
                val two = doSomethingUseful2()

                val result = one + two
                Log.v("TAG", "The result is $result")
            }
        }

    }

    suspend fun doSomethingUseful1(): Int{
        delay(5000)
        Log.v("TAG", "Function 1 is done")
        return 11
    }

    suspend fun doSomethingUseful2(): Int{
        delay(7000)
        Log.v("TAG", "Function 2 is done")
        return 10
    }
}