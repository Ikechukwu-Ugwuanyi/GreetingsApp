package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.practice.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data)

        val u1 : User = User(13, "Ikechukwu", "android")
        binding.user = u1
    }
}