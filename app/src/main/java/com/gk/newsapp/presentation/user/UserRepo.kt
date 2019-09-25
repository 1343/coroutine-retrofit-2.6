package com.gk.newsapp.presentation.user

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import com.gk.newsapp.core.base.BaseRepo
import com.gk.newsapp.core.ext.isValidEmailAddress
import com.gk.newsapp.db.User

open class UserRepo : BaseRepo() {

    private val mutableLiveData = MutableLiveData<String>()
    fun getUserObserver(): MutableLiveData<String> {
        return mutableLiveData;
    }


    private fun checkValidation(user: User): Boolean {
        if (TextUtils.isEmpty(user.firstName)) {
            mutableLiveData.postValue("User first name empty")
            return false

        }
        if (TextUtils.isEmpty(user.lastName)) {
            mutableLiveData.postValue("User last name empty")
            return false

        }

        if (TextUtils.isEmpty(user.email)) {
            mutableLiveData.postValue("User email empty")
            return false

        }
        if (!user.email!!.isValidEmailAddress()) {
            mutableLiveData.postValue("User email is not valid")
            return false

        }

        return true
    }

    suspend fun addUser(user: User) {
        if (!checkValidation(user)) {
            return
        }
        mockApi.addUSer(user)
        userDao.insertAll(user)
        mutableLiveData.postValue("Success")
    }

    suspend fun updateUser(user: User) {
        if (!checkValidation(user)) {
            return
        }
        mockApi.editUser(user)
        userDao.update(user)
        mutableLiveData.postValue("Success")
    }


}