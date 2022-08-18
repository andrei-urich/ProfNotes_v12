package ru.profsoft.profnotes_v1.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.profsoft.profnotes_v1.R
import ru.profsoft.profnotes_v1.core.Note
import ru.profsoft.profnotes_v1.databinding.ItemNewNoteBinding

class NewNotesAdapter : RecyclerView.Adapter<NewNotesAdapter.ViewHolder>() {
    val noteList = ArrayList<Note>()

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemNewNoteBinding.bind(item)
        fun bind(note: Note) = with(binding) {
            ivUser.setImageResource(note.imageId)
            tvTitle.text = note.title
            tvDescription.text = note.description
            tvDate.text = note.date
            ivUser1.setImageResource(note.userImage[0])
            ivUser1.setImageResource(note.userImage[1])
            ivUser1.setImageResource(note.userImage[2])
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_new_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

}
