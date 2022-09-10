package ru.profsoft.profnotes_v1.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.profsoft.profnotes_v1.R
import ru.profsoft.profnotes_v1.model.entity.Note
import ru.profsoft.profnotes_v1.databinding.ItemNoteBinding
import ru.profsoft.profnotes_v1.databinding.ItemTaskBinding
import ru.profsoft.profnotes_v1.model.entity.Task

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    var taskList = emptyList<Task>()

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemTaskBinding.bind(item)
        fun bind(task: Task) = with(binding) {
            tvStatus.text = task.status
            tvTaskHead.text = task.head
            tvTaskBody.text = task.body
            tvTaskTime.text = task.date

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addTask(newTask: List<Task>) {
        taskList=newTask
        notifyDataSetChanged()
        }
    }


