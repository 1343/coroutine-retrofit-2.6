package com.gk.newsapp.dagger.module

import android.app.Application
import androidx.room.Room
import com.gk.newsapp.db.AppDatabase
import com.gk.newsapp.network.ApiCall
import com.gk.newsapp.network.MockApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getApiClient(): ApiCall {
        return Retrofit.Builder()
            .baseUrl("https://d781v.mocklab.io/")
            .client(
                OkHttpClient()
            ).addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiCall::class.java)
    }

    @Provides
    @Singleton
    fun getMockApi(): MockApi {
        return Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/5d8b54c93500006200d46ece/")
            .client(
                OkHttpClient()
            ).addConverterFactory(GsonConverterFactory.create())
            .build().create(MockApi::class.java)
    }


}