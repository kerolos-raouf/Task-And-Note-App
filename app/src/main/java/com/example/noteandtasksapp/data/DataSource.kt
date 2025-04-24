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

    fun getEmojiBasedOnProgress(progressPercent: Int): String {
        return when (progressPercent) {
            0 -> "😐"
            in 1..24 -> "😕"
            in 25..49 -> "😌"
            in 50..74 -> "🙂"
            else -> "😄"
        }
    }
}