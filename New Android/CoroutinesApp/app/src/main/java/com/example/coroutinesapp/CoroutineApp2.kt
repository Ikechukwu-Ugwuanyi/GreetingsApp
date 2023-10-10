package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.coroutinesapp.databinding.ActivityCoroutineApp2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CoroutineApp2 : AppCompatActivity() {

    private lateinit var binding: ActivityCoroutineApp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine_app2)
        hello()
        hello2()




    }

    private fun hello2() {
        CoroutineScope(Dispatchers.IO).launch {
            binding.textView5.text = "Hello from ${Thread.currentThread().name}"
        }
    }

    private fun hello() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.textView4.text = "Hello from ${Thread.currentThread().name}"
        }
    }


}