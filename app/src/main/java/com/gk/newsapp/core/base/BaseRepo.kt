package com.gk.newsapp.core.base

import android.util.Log
import com.gk.newsapp.NewsApp
import com.gk.newsapp.dagger.component.DaggerAppComponent
import com.gk.newsapp.dagger.module.AppModule
import com.gk.newsapp.dagger.module.RoomModule
import com.gk.newsapp.db.UserDao
import com.gk.newsapp.network.ApiCall
import com.gk.newsapp.network.MockApi
import javax.inject.Inject

open class BaseRepo {
    @Inject
    lateinit var apiCall: ApiCall
    @Inject
    lateinit var mockApi: MockApi
    @Inject
    lateinit var userDao: UserDao

    init {
        DaggerAppComponent.builder().roomModule(RoomModule(NewsApp.getNewsApp())).build()
            .inject(this)
        Log.i("", "")
    }
}