package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.practice.databinding.ActivityViewmodelBinding

class ViewmodelActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewmodelBinding
    lateinit var viewModel : ViewModelActivityViewModel
    lateinit var factory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel)

        viewModel = ViewModelProvider(this, factory).get(ViewModelActivityViewModel::class.java)

        factory = ViewModelFactory(100)


        binding.textView4.text = viewModel.getCurrentCount().toString()

        binding.btn.setOnClickListener() {

            binding.textView4.text = viewModel.getUpdatedCount().toString()
        }

    }
}