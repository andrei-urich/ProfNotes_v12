package ru.profsoft.profnotes_v1.model.entity

import androidx.room.Entity

@Entity ()
data class Task(
    val status: String,
    val head: String,
    val body: String,
    val date: String
)