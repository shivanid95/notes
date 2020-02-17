package com.example.notes.data


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