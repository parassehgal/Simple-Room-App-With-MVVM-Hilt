package com.example.mvvmsample.app

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class
 * Created by Paras Sehgal
 */
@HiltAndroidApp
class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        lateinit var appContext: Context
    }

}