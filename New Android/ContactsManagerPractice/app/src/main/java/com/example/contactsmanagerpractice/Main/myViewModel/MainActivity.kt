package com.example.contactsmanagerpractice.Main.myViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.contactsmanagerpractice.Main.model.UserDb
import com.example.contactsmanagerpractice.Main.model.UserRepository
import com.example.contactsmanagerpractice.R
import com.example.contactsmanagerpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = UserDb.getInstance(application).userDAO
        val repository = UserRepository(dao)
        val factory = ViewModelFactory(repository)

        binding.userViewModel = userViewModel

        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        TODO("Not yet implemented")
    }


}