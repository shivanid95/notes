package com.example.notes.notesList

import com.example.notes.data.Note

/**
 * Listener used with data binding to process user actions.
 * Handles on click of a Note item
 */
interface NoteOnClickListener {

    fun onNoteClicked(note: Note?)

}