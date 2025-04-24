package com.example.noteandtasksapp.ui.adapters

import android.util.Printer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteandtasksapp.R
import com.example.noteandtasksapp.data.model.Note

class NotesAdapter(
    private val notesList: List<Note>,
    private val onDelete: (Note) -> Unit,
    private val onItemClick: (Note) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item: CardView = itemView.findViewById(R.id.note_layout)
        val title: TextView = itemView.findViewById(R.id.note_title)
        val desc: TextView = itemView.findViewById(R.id.note_desc)
        val delete: ImageView = itemView.findViewById(R.id.note_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.title.text = notesList[position].title
        holder.desc.text = notesList[position].description

        holder.delete.setOnClickListener {
            onDelete(notesList[position])
            notifyDataSetChanged()
        }

        holder.item.setOnClickListener {
            onItemClick(notesList[position])
        }
    }

    override fun getItemCount() = notesList.size
}