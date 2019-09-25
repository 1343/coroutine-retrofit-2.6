package com.gk.newsapp.presentation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gk.newsapp.core.base.BaseViewModel
import com.gk.newsapp.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel : BaseViewModel<UserRepo>() {

    private val userRepo = UserRepo()

    fun getUserObserver(): MutableLiveData<String> {
        return userRepo.getUserObserver();
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepo.addUser(user)

            }
        }
    }

    fun editUser(user: User) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepo.updateUser(user)

            }

        }
    }

}