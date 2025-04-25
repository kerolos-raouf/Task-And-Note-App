package com.example.noteandtasksapp.ui.screens

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import com.example.noteandtasksapp.R
import com.example.noteandtasksapp.data.DataSource
import com.example.noteandtasksapp.data.FontSize

class SettingsActivity : BaseActivity() {

    private lateinit var radioSmall: RadioButton
    private lateinit var radioNormal: RadioButton
    private lateinit var radioMedium: RadioButton
    private lateinit var radioLarge: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        findViewById<ImageView>(R.id.arrow_back).setOnClickListener {
            finish()
        }

        radioSmall = findViewById(R.id.radio_small)
        radioNormal = findViewById(R.id.radio_normal)
        radioMedium = findViewById(R.id.radio_medium)
        radioLarge = findViewById(R.id.radio_large)

        radioSmall.isChecked = DataSource.currentFontSize == DataSource.fontSizeMap[FontSize.SMALL]
        radioNormal.isChecked = DataSource.currentFontSize == DataSource.fontSizeMap[FontSize.NORMAL]
        radioMedium.isChecked = DataSource.currentFontSize == DataSource.fontSizeMap[FontSize.MEDIUM]
        radioLarge.isChecked = DataSource.currentFontSize == DataSource.fontSizeMap[FontSize.LARGE]

        radioSmall.setOnClickListener {
            DataSource.currentFontSize = DataSource.fontSizeMap[FontSize.SMALL] ?: 1f
            recreate()
        }

        radioNormal.setOnClickListener {
            DataSource.currentFontSize = DataSource.fontSizeMap[FontSize.NORMAL] ?: 1f
            recreate()
        }

        radioMedium.setOnClickListener {
            DataSource.currentFontSize = DataSource.fontSizeMap[FontSize.MEDIUM] ?: 1f
            recreate()
        }

        radioLarge.setOnClickListener {
            DataSource.currentFontSize = DataSource.fontSizeMap[FontSize.LARGE] ?: 1f
            recreate()
        }
    }
}