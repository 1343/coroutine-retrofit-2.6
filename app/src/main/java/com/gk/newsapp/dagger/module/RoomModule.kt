package com.gk.newsapp.dagger.module


import android.app.Application
import androidx.room.Room

import com.gk.newsapp.db.AppDatabase
import com.gk.newsapp.db.UserDao

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class RoomModule(mApplication: Application) {

    private val demoDatabase: AppDatabase

    init {
        demoDatabase =
            Room.databaseBuilder(mApplication, AppDatabase::class.java, "demo-db").build()
    }

    @Singleton
    @Provides
    internal fun providesRoomDatabase(): AppDatabase {
        return demoDatabase
    }

    @Singleton
    @Provides
    internal fun providesProductDao(demoDatabase: AppDatabase): UserDao {
        return demoDatabase.userDao()
    }


}
