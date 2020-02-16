package com.example.notes.notesList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.data.Note

class NotesListAdaptor: RecyclerView.Adapter<NotesListAdaptor.NoteItemViewHolder>() {


    private val data = listOf(
        Note("Hello", "First note"),
        Note("Reminder", "remind me to do somwthing"),
        Note("last", "cld,dl,l")
    )


    override fun getItemCount(): Int  = data.count()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        return  NoteItemViewHolder.from(parent)


    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }



    /**
     * Note List Cell View Holder
     */
    class NoteItemViewHolder private constructor (itemView: View): RecyclerView.ViewHolder(itemView) {

        val noteTitleTextView: TextView = itemView.findViewById(R.id.note_title_text)

        fun bind(
            item: Note
        ) {
            noteTitleTextView.text = item.title
        }


        companion object {
            fun from(parent: ViewGroup): NoteItemViewHolder {
                val viewInflater = LayoutInflater.from(parent.context)
                val view = viewInflater.inflate(R.layout.note_list_item, parent, false)
                return NoteItemViewHolder(view)
            }
        }


    }

}