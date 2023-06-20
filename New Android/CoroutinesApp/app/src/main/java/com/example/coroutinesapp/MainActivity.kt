package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnCount.setOnClickListener {
            binding.textView.text = counter++.toString()
        }

        binding.btnDownload.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch{
                downloadBigFile()
            }

        }

    }

    private fun downloadBigFile() {
        for (i in 1..100000) {
            Log.i("TAG", "Downloading $i on ${Thread.currentThread().name}")
        }
    }

}