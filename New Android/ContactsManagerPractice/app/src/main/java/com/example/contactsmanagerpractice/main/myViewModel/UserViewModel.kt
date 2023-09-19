package com.example.contactsmanagerpractice.main.myViewModel


import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsmanagerpractice.main.model.User
import com.example.contactsmanagerpractice.main.model.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private  val repository: UserRepository) : ViewModel(), Observable {

    val users = repository.users
    var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: User

    @Bindable
    var inputName = MutableLiveData<String?>()

    @Bindable
    var inputEmail = MutableLiveData<String?>()

    @Bindable
    var saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    var deleteOrClearAllButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        deleteOrClearAllButtonText.value = "Clear All"
    }

    fun updateOrSave() {
        if (isUpdateOrDelete) {
            userToUpdateOrDelete.name = inputName.value!!
            userToUpdateOrDelete.email = inputEmail.value!!

            update(userToUpdateOrDelete)
        } else {

            val name = inputName.value!!
            val email = inputEmail.value!!

            insert(User(0, name, email))

            inputName.value = null
            inputEmail.value = null
        }
    }

    fun deleteOrClearAll() {
        if (isUpdateOrDelete) {
            delete(userToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    private fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

    private fun clearAll() = viewModelScope.launch{
        repository.deleteAll()
    }

    private fun update(user: User) = viewModelScope.launch {
        repository.update(user)

        //FResetting the fields
        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        deleteOrClearAllButtonText.value = "Clear All"

    }

    private fun delete(user: User) = viewModelScope.launch{
        repository.deleteUser(user)

        //Resetting the fields
        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        deleteOrClearAllButtonText.value = "Clear All"

    }

    fun initUpdateOrDelete(user: User) {
        inputName.value = user.name
        inputEmail.value = user.email
        isUpdateOrDelete = true
        saveOrUpdateButtonText.value = "Update"
        deleteOrClearAllButtonText.value = "Delete"
        userToUpdateOrDelete = user

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}