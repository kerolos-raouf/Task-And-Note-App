package com.example.noteandtasksapp.data.model

data class Note(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val description: String
)
