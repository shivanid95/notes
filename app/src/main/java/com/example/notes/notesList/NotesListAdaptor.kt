package com.example.notes.notesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.notes.data.Note
import com.example.notes.databinding.NoteListItemBinding

/**
 * Adapter that provides a list of [Note] to a recycler view
 */
class NotesListAdaptor(val viewModel: NotesListViewModel): ListAdapter<Note, NotesListAdaptor.NoteItemViewHolder>(NotesListDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        return  NoteItemViewHolder.from(parent)


    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val item = getItem(position)
        val userActionListener = object : NoteOnClickListener {
            override fun onNoteClicked(note: Note?) {
                if (note != null)  viewModel.openNote(note!!)
            }
        }

        holder.bind(item, userActionListener)
    }



    /**
     * Note List Cell View Holder
     */
    class NoteItemViewHolder private constructor (val binding: NoteListItemBinding): RecyclerView.ViewHolder(binding.root) {

        /**
         * binds the data with the layout
         */
        fun bind(item: Note, listener: NoteOnClickListener) {
           binding.noteTitleText.text = item.title
            binding.note = item
           binding.listener = listener

        }


        companion object {
            /**
             * Creates a new view holder cell
             */
            fun from(parent: ViewGroup): NoteItemViewHolder {
                //Create Inflater
                val viewInflater = LayoutInflater.from(parent.context)
                //Inflate Using Binding
                val binding = NoteListItemBinding.inflate(viewInflater, parent, false)

                return NoteItemViewHolder(binding)
            }
        }
    }



}


/**
 * Callback for calculating the diff between two non-null items in a list.
 * Used by ListAdapter to calculate the minumum number of changes between and old list and a new
 */
class NotesListDiffCallback: DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        //TODO("change logic to compare dates")
        return oldItem.title == newItem.title && oldItem.content == newItem.content
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }


}