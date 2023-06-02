package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var factory: MainActivityViewModelFactory
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding Object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //ViewModel
        viewModel = ViewModelProvider(this, factory)
            .get(MainActivityViewModel::class.java)

        //ViewModel Factory
        factory = MainActivityViewModelFactory(100)


        binding.textView.text = viewModel
            .getCurrentCount().toString()

        binding.btn.setOnClickListener() {
            binding.textView.text = viewModel.getUpdatedCount().toString()
        }
    }
}