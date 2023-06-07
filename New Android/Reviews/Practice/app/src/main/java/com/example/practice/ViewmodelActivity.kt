package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.practice.databinding.ActivityViewmodelBinding

class ViewmodelActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewmodelBinding
    lateinit var viewModel : ViewModelActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel)

        viewModel = ViewModelProvider(this).get(ViewModelActivityViewModel::class.java)

        binding.textView4.text = viewModel.getCurrentCount().toString()

        binding.btn.setOnClickListener() {

            binding.textView4.text = viewModel.getUpdatedCount().toString()
        }

    }
}