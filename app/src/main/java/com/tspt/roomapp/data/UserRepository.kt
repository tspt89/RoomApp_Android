package com.tspt.roomapp.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao : UserDao) {

    val readAllData : LiveData<List<User>> = userDao.readdAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}