package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityDataBindingObjectsBinding
import com.example.databinding.databinding.ActivityMainBinding

class DataBindingObjects : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingObjectsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_objects)

        var u1: User = User(2, "Jack", "123")
        binding.user = u1

    }
}