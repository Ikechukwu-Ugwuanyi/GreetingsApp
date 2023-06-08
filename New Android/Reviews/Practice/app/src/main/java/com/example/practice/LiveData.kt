package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.practice.databinding.ActivityLiveDataBinding

class LiveData : AppCompatActivity() {

    lateinit var binding: ActivityLiveDataBinding
    lateinit var viewModel: LiveDataViewModel
    lateinit var factory: LiveDataFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data)

        factory = LiveDataFactory(200)

        viewModel = ViewModelProvider(this, factory).get(LiveDataViewModel::class.java)
    }
}