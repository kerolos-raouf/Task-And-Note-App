package com.example.noteandtasksapp.ui.screens

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.noteandtasksapp.R
import com.example.noteandtasksapp.data.DataSource
import com.example.noteandtasksapp.ui.adapters.TasksAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TasksActivity : AppCompatActivity() {

    private lateinit var adapter: TasksAdapter
    private lateinit var progressText : TextView
    private lateinit var progressEmoji : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)
        progressText = findViewById(R.id.tasks_progress_text)
        progressEmoji = findViewById(R.id.tasks_progress_emoji)
        setProgress()

        findViewById<FloatingActionButton>(R.id.tasks_fab).setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }

        adapter = TasksAdapter(
            taskList = DataSource.taskList,
            onDelete = {
                DataSource.taskList.remove(it)
                setProgress()
            },
            onItemClick = {
                val intent = Intent(this, AddTaskActivity::class.java)
                intent.putExtra(TITLE_KEY, it.title)
                startActivity(intent)
            },
            onCheck = { task, isChecked ->
                DataSource.taskList.find { it.id == task.id }?.isDone = isChecked
                setProgress()
            }
        )

        findViewById<RecyclerView>(R.id.tasks_recycler_view).adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        setProgress()
        adapter.notifyDataSetChanged()
    }

    private fun setProgress(){
        val progress = DataSource.taskList.filter { it.isDone }.size
        val progressPercent = (progress.toDouble() / DataSource.taskList.size.toDouble() * 100).toInt()

        progressText.text = "$progress/${DataSource.taskList.size}"
        progressEmoji.text = DataSource.getEmojiBasedOnProgress(progressPercent)
    }
}