package com.example.noteandtasksapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteandtasksapp.R
import com.example.noteandtasksapp.data.model.Task

class TasksAdapter(
    private val taskList: List<Task>,
    private val onDelete: (Task) -> Unit,
    private val onItemClick: (Task) -> Unit,
    private val onCheck: (Task, Boolean) -> Unit
) : RecyclerView.Adapter<TasksAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item: CardView = itemView.findViewById(R.id.task_layout)
        val title: TextView = itemView.findViewById(R.id.task_title)
        val delete: ImageView = itemView.findViewById(R.id.task_delete)
        val checkBox: CheckBox = itemView.findViewById(R.id.task_check_box)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.title.text = taskList[position].title
        holder.checkBox.isChecked = taskList[position].isDone

        holder.delete.setOnClickListener {
            onDelete(taskList[position])
            notifyDataSetChanged()
        }

        holder.item.setOnClickListener {
            onItemClick(taskList[position])
        }

        holder.checkBox.setOnClickListener {
            onCheck(taskList[position], holder.checkBox.isChecked)
        }
    }

    override fun getItemCount() = taskList.size
}