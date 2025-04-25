package com.example.noteandtasksapp.ui.screens

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.noteandtasksapp.R
import com.example.noteandtasksapp.data.DataSource
import com.example.noteandtasksapp.data.model.Task

class AddTaskActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val titleEditText = findViewById<EditText>(R.id.add_task_title)
        val addNoteBtn = findViewById<Button>(R.id.add_task_btn)
        findViewById<Button>(R.id.back_btn).setOnClickListener {
            finish()
        }

        val titleValue = intent.getStringExtra(TITLE_KEY)

        if (titleValue != null) {
            titleEditText.setText(titleValue)
        }

        addNoteBtn.setOnClickListener {
            val title = titleEditText.text.toString()
            val task = Task(title = title)
            if (title.isEmpty()) {
                Toast.makeText(this, "Please Enter Title and Description", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            DataSource.taskList.add(task)
            Toast.makeText(this, "Task Add Successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}