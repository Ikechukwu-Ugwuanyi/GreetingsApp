package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.coroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityMainBinding
    private var counter : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnCount.setOnClickListener{
            binding.textView.text = counter++.toString()

        }

        binding.btnDownload.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadBigFile()
            }
        }

    }

    //Only the original thread that created a view hierarchy can touch its views.

    private suspend fun downloadBigFile() {
        for (i in 0..1000000) {
            withContext(Dispatchers.Main) {
                binding.context.text = "$i downloading on ${Thread.currentThread().name}"
            }
        }
    }

}