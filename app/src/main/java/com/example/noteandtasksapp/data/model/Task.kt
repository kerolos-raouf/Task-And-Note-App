package com.example.noteandtasksapp.data.model

data class Task(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    var isDone: Boolean = false
)
