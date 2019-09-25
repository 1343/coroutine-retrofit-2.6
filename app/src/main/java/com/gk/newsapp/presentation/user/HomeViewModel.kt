package com.gk.newsapp.presentation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gk.newsapp.core.base.BaseViewModel
import com.gk.newsapp.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : BaseViewModel<HomeRepo>() {

    val homeRepo = HomeRepo()
    fun getUserList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                homeRepo.getUser()
            }

        }
    }

    fun getUserObserver(): MutableLiveData<List<User>> {
        return homeRepo.getUserObserver()
    }

}