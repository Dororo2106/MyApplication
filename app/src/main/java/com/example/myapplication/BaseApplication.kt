package com.example.myapplication

import android.app.Application


class BaseApplication : Application() {
    val  appComponent:AppComponent by lazy{
        DaggerAppComponent.builder().build()
    }

    override fun Oncreate(){
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE:  BaseApplication
    }
}