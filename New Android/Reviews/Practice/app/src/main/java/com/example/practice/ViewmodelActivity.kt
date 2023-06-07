package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.practice.databinding.ActivityViewmodelBinding

class ViewmodelActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewmodelBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel)


        binding.btn.setOnClickListener() {
            counter++
            binding.textView4.setText(counter).toString()
        }


    }
}