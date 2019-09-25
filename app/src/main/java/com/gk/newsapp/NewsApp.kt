package com.gk.newsapp

import android.app.Application

class NewsApp : Application() {

    companion object {
        private lateinit var newsApp: NewsApp

        fun getNewsApp(): NewsApp {
            return newsApp
        }

    }

    override fun onCreate() {
        super.onCreate()
        newsApp = this
    }


}