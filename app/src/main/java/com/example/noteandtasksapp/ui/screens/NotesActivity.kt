package com.example.noteandtasksapp.ui.screens

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteandtasksapp.R
import com.example.noteandtasksapp.data.DataSource
import com.example.noteandtasksapp.ui.adapters.NotesAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NotesActivity : BaseActivity() {

    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        findViewById<FloatingActionButton>(R.id.note_fab).setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.arrow_back).setOnClickListener {
            finish()
        }

        adapter = NotesAdapter(
            notesList = DataSource.noteList,
            onDelete = {
                DataSource.noteList.remove(it)
            },
            onItemClick = {
                val intent = Intent(this, AddNoteActivity::class.java)
                intent.putExtra(TITLE_KEY, it.title)
                intent.putExtra(DESC_KEY, it.description)
                startActivity(intent)
            }
        )

        findViewById<RecyclerView>(R.id.notes_recycler_view).adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter.notifyDataSetChanged()
    }
}