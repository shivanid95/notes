package com.example.notes.data

/**
 * Singleton to store all the notes in a session
 */
object NotesRepository {

     private val _notes: MutableList<Note> = mutableListOf()
     val notes: List<Note>
        get() = _notes


    fun add(note: Note) {
        if (note.title.isNotEmpty() && note.content.isNotEmpty()) {
            _notes.add(note)
        }
    }

}