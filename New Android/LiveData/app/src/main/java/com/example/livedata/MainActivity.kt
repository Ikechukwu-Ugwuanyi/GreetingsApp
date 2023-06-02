package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        factory = MainActivityViewModelFactory(200)

        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)

        //Observing Data Change
        viewModel.totalSum.observe(
            this,
            Observer {
                binding.textView2.text = it.toString()
            }
        )

        binding.btn.setOnClickListener{
            viewModel.sumUp(binding.editText.text.toString().toInt())
        }



    }
}