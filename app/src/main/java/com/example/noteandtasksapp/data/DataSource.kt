package com.example.noteandtasksapp.data

import com.example.noteandtasksapp.data.model.Note
import com.example.noteandtasksapp.data.model.Task

object DataSource {
    val fontSizeMap = mapOf(
        FontSize.SMALL to 0.6f,
        FontSize.NORMAL to 1f,
        FontSize.MEDIUM to 1.5f,
        FontSize.LARGE to 2f
    )

    var previousFontSize = fontSizeMap.getValue(FontSize.NORMAL)
    var currentFontSize = fontSizeMap.getValue(FontSize.NORMAL)

    val taskList = mutableListOf<Task>()

    val noteList = mutableListOf<Note>()

    fun getEmojiBasedOnProgress(progressPercent: Int): String {
        return when (progressPercent) {
            0 -> "😐"
            in 1..25 -> "😕"
            in 26..50 -> "😌"
            in 51..75 -> "🙂"
            else -> "😄"
        }
    }
}