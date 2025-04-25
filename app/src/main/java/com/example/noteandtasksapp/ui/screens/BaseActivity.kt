package com.example.noteandtasksapp.ui.screens

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import com.example.noteandtasksapp.data.DataSource

open class BaseActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context?) {
        val config = Configuration(newBase?.resources?.configuration)
        config.fontScale = DataSource.currentFontSize

        val context = newBase?.createConfigurationContext(config)
        super.attachBaseContext(context)
    }
}