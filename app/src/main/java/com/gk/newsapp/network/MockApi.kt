package com.gk.newsapp.network

import com.gk.newsapp.db.User
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface MockApi {

    @POST("user")
    suspend fun addUSer(@Body user: User): Response

    @PUT("user")
    suspend fun editUser(@Body user: User): Response
}