package com.example.contactsmanagerpractice.main.myViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsmanagerpractice.main.model.User
import com.example.contactsmanagerpractice.main.model.UserDb
import com.example.contactsmanagerpractice.main.model.UserRepository
import com.example.contactsmanagerpractice.main.viewUI.UserAdapter
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

        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        binding.userViewModel = userViewModel

        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        displayUsersList()
    }

    private fun displayUsersList() {
        userViewModel.users.observe(this, Observer {
            binding.recyclerView.adapter = UserAdapter(it) {
                selectedItem : User -> listItemClicked(selectedItem)
            }
        })
    }

    private fun listItemClicked(selectedItem: User) {
        Toast.makeText(this, "The selected Item is ${selectedItem.name}", Toast.LENGTH_LONG)
            .show()
        userViewModel.initUpdateOrDelete(selectedItem)
    }


}