package com.example.newsinshortjetpackcompose

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: coming inside Application")
    }

    companion object{
        const val TAG = "NewsApplication"
    }
}