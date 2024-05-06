package com.example.myapplication

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen
import data.ui.MainActivity

object Screens {
    fun Main() = ActivityScreen{
        Intent(it, MainActivity:: class.java)
    }
}