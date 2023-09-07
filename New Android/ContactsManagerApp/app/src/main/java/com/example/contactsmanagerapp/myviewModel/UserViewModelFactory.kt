package com.example.contactsmanagerapp.myviewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.contactsmanagerapp.room.UserRepository

class UserViewModelFactory(private val repository: UserRepository) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}