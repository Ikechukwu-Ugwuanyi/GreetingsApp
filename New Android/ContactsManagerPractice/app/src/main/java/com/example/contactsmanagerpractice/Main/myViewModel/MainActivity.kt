package com.example.contactsmanagerpractice.Main.myViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsmanagerpractice.Main.model.User
import com.example.contactsmanagerpractice.Main.model.UserDb
import com.example.contactsmanagerpractice.Main.model.UserRepository
import com.example.contactsmanagerpractice.Main.viewUI.UserAdapter
import com.example.contactsmanagerpractice.R
import com.example.contactsmanagerpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    //private  lateinit var adapter :UserAdapter


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
        Toast.makeText(this, "The seleceted Item is ${selectedItem.name}", Toast.LENGTH_LONG).show()
        binding.userViewModel.initUpdateOrDelete(selectedItem)
    }


}