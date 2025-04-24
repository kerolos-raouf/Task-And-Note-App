package com.example.noteandtasksapp.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.noteandtasksapp.R
import com.example.noteandtasksapp.data.DataSource
import com.example.noteandtasksapp.ui.adapters.NotesAdapter
import com.example.noteandtasksapp.ui.adapters.TasksAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TasksActivity : AppCompatActivity() {

    private lateinit var adapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        findViewById<FloatingActionButton>(R.id.tasks_fab).setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }

        adapter = TasksAdapter(
            taskList = DataSource.taskList,
            onDelete = {
                DataSource.taskList.remove(it)
            },
            onItemClick = {
                val intent = Intent(this, AddNoteActivity::class.java)
                intent.putExtra(TITLE_KEY, it.title)
                intent.putExtra(DESC_KEY, it.description)
                startActivity(intent)
            },
            onCheck = { task, isChecked ->
                DataSource.taskList.find { it.id == task.id }?.isDone = isChecked
            }
        )

        findViewById<RecyclerView>(R.id.tasks_recycler_view).adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter.notifyDataSetChanged()
    }
}