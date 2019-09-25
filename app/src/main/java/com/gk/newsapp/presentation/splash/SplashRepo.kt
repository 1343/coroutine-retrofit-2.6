package com.gk.newsapp.presentation.splash

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.gk.newsapp.core.base.BaseRepo
import com.gk.newsapp.presentation.user.HomeActivity

class SplashRepo : BaseRepo() {

    fun navigateToHomePage(): MutableLiveData<Class<*>> {
        val activityLiveData = MutableLiveData<Class<*>>()
        Handler().postDelayed({ activityLiveData.postValue(HomeActivity::class.java) }, 1000)
        return activityLiveData
    }
}