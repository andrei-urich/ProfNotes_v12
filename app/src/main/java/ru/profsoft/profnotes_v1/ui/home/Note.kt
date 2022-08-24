package ru.profsoft.profnotes_v1.ui.home

data class Note(
    val imageId: Int,
    val title: String,
    val description: String,
    val date: String,
    val userImage: ArrayList<Int>
)
