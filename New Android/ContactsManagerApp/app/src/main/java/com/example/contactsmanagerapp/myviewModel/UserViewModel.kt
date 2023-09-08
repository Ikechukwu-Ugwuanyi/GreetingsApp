package com.example.contactsmanagerapp.myviewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsmanagerapp.room.User
import com.example.contactsmanagerapp.room.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) :ViewModel(), Observable {

    val users = repository.users
    var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: User

    @Bindable
    val  inputName = MutableLiveData<String?>()

    @Bindable
    val inputEmail = MutableLiveData<String?>()

    @Bindable
    val saveOrDeleteButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrDeleteButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        val name = inputName.value!!
        val email = inputEmail.value!!

        insert(User(0, name, email))

        inputName.value = null
        inputEmail.value = null
    }

    fun clearAllOrDelete() {
        clearAll()
    }

    private fun insert(user: User) = viewModelScope.launch{
        repository.insert(user)
    }

    private fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun update(user: User) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: User) = viewModelScope.launch {
        repository.delete(user)
    }

    fun initUpdateAndDelete(selectedItem: User) {

    }







    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}