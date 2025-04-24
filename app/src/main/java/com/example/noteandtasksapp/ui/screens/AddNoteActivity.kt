package com.example.noteandtasksapp.ui.screens

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noteandtasksapp.R
import com.example.noteandtasksapp.data.DataSource
import com.example.noteandtasksapp.data.model.Note

const val TITLE_KEY = "title_key"
const val DESC_KEY = "desc_key"

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        val titleEditText = findViewById<EditText>(R.id.add_note_title)
        val descEditText = findViewById<EditText>(R.id.add_note_desc)
        val addNoteBtn = findViewById<Button>(R.id.add_note_btn)

        val titleValue = intent.getStringExtra(TITLE_KEY)
        val descValue = intent.getStringExtra(DESC_KEY)

        if (titleValue != null) {
            titleEditText.setText(titleValue)
        }

        if (descValue != null) {
            descEditText.setText(descValue)
        }

        addNoteBtn.setOnClickListener {
            val title = titleEditText.text.toString()
            val desc = descEditText.text.toString()
            val note = Note(title = title, description =  desc)
            if (title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Please Enter Title and Description", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            DataSource.noteList.add(note)
            Toast.makeText(this, "Note Add Successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}