package ru.profsoft.profnotes_v1.model.entity
import android.media.Image
import androidx.room.Entity

@Entity ()
data class User(
    val id: String,
    val login: String,
    val password: String,
    val image: Image
)