package com.example.noteandtasksapp.data

import com.example.noteandtasksapp.data.model.Note
import com.example.noteandtasksapp.data.model.Task

object DataSource {
    val taskList = mutableListOf<Task>()

    val noteList = mutableListOf<Note>(
        Note(title = "Test Title", description =  "Test Description"),
        Note(title = "Test Title", description =  "Test Description"),
        Note(title = "Test Title", description =  "Test Description"),
        Note(title = "Test Title", description =  "Test Description"),
        Note(title = "Test Title", description =  "Test Description"),
    )
}