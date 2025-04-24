package com.example.noteandtasksapp.data.model

data class Task(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val description: String,
    var isDone: Boolean = false
)
