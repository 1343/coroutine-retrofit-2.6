package com.gk.newsapp.network

import com.gk.newsapp.db.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiCall {

    @GET("user")
    suspend fun getUserList(): List<User>
}