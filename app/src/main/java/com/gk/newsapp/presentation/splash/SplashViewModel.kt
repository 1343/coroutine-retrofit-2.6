package com.gk.newsapp.presentation.splash

import androidx.lifecycle.MutableLiveData
import com.gk.newsapp.core.base.BaseViewModel

class SplashViewModel : BaseViewModel<SplashRepo>() {
    fun navigateToHomePage(): MutableLiveData<Class<*>> {
        val splashRepo = SplashRepo()
        return splashRepo.navigateToHomePage();
    }
}