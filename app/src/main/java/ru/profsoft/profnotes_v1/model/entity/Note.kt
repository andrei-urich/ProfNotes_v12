package ru.profsoft.profnotes_v1.model.entity
import androidx.room.Entity

@Entity ()
data class Note(
    val imageId: Int,
    val title: String,
    val description: String,
    val date: String,
    val userImage: Int
)
