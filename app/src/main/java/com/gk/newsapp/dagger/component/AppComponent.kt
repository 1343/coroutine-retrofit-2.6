package com.gk.newsapp.dagger.component

import com.gk.newsapp.core.base.BaseRepo
import com.gk.newsapp.dagger.module.AppModule
import com.gk.newsapp.dagger.module.NetworkModule
import com.gk.newsapp.dagger.module.RoomModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class, RoomModule::class])
interface AppComponent {

    fun inject(baseRepo: BaseRepo)

}