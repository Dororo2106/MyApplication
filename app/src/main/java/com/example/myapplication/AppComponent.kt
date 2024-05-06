package com.example.myapplication

import com.example.myapplication.module.MainModule
import data.ui.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [MainModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}