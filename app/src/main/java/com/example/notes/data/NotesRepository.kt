package com.example.notes.data


object NotesRepository {


    private var notes: List<Note> = emptyList()
        private set


    fun add(note: Note) {
        if (note.title.isNotEmpty() && note.content.isNotEmpty()) {
            notes.plus(note)
        }
    }

    fun clearAll() {
        notes = emptyList()
    }
}