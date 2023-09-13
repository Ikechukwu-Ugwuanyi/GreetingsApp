package com.example.contactsmanagerpractice.Main.myViewModel

import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import com.example.contactsmanagerpractice.Main.model.UserRepository

class UserViewModel(private  val repository: UserRepository) : ViewModel(), Observable {





    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}