package com.example.noteandtasksapp.ui.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.noteandtasksapp.R
import com.example.noteandtasksapp.data.DataSource

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.go_to_tasks).setOnClickListener {
            val intent = Intent(this, TasksActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.go_to_notes).setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.go_to_settings).setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        if (DataSource.currentFontSize != DataSource.previousFontSize) {
            DataSource.previousFontSize = DataSource.currentFontSize
            recreate()
        }
    }
}