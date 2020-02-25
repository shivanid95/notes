package com.example.notes.data

/**
 * Singleton to store all the notes in a session
 */
object NotesRepository {

    private val data = listOf<Note>(
        Note("New Note 1", "ajsshfhk some random descrition"),
        Note("New Note 2", "ajsshfhk some random descrition"),
        Note("New Note 3", "ajsshfhk some random descrition"),
        Note("New Note 4", "ajsshfhk some random descrition"))

     private val _notes: MutableList<Note> = data.toMutableList()
     val notes: List<Note>
        get() = _notes


    fun add(note: Note) {
        if (note.title.isNotEmpty() && note.content.isNotEmpty()) {
            _notes.add(note)
        }
    }

}