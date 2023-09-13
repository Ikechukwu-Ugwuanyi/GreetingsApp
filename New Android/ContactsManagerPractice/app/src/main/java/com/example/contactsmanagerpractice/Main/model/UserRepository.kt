package com.example.contactsmanagerpractice.Main.model

class UserRepository(private val dao: UserDAO) {

    val users = dao.getAllUsersInDb()

    suspend fun insert(user: User) {
        dao.insertUser(user)
    }

    suspend fun update(user: User) {
        dao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        dao.deleteUser(user)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}