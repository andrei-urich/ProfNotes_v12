package ru.profsoft.profnotes_v1.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.profsoft.profnotes_v1.R
import ru.profsoft.profnotes_v1.model.entity.Note
import ru.profsoft.profnotes_v1.databinding.ItemNoteBinding

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    var noteList = emptyList<Note>()

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemNoteBinding.bind(item)
        fun bind(note: Note) = with(binding) {
            ivUser.setImageResource(note.imageId)
            tvTitle.text = note.title
            tvDescription.text = note.description
            tvDate.text = note.date
            ivUser1.setImageResource(note.userImage)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNote(newNotes: List<Note>) {
        noteList=newNotes
        notifyDataSetChanged()
        }
    }


