package com.gk.newsapp.presentation.user

import androidx.lifecycle.MutableLiveData
import com.gk.newsapp.core.base.BaseRepo
import com.gk.newsapp.db.User

class HomeRepo : BaseRepo() {
    val mutableLiveData = MutableLiveData<List<User>>()

    fun getUserObserver(): MutableLiveData<List<User>> {
        return mutableLiveData;
    }

    suspend fun getUser() {
        val userList = userDao.getAll()

        if (userList.isEmpty()) {
            val data = apiCall.getUserList()
            if (data != null) {
                for (user in data) {
                    userDao.insertAll(user)
                }
            }
            mutableLiveData.postValue(data)


        } else {
            mutableLiveData.postValue(userDao.getAll())

        }
    }

}