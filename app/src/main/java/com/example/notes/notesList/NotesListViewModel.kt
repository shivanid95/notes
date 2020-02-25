package com.example.notes.notesList

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.notes.data.Note
import com.example.notes.data.NotesRepository
import com.example.notes.utility.Event


class NotesListViewModel : ViewModel() {

    // List of notes added
    private val _notes = MutableLiveData<List<Note>>().apply { value = emptyList() }
    val notes: LiveData<List<Note>>
        get() = _notes

    // Live data depending on notes list, returns true if list is empty
    val isNotesListEmpty: LiveData<Boolean> = Transformations.map(notes){
        it.isEmpty()
    }

    fun add() {
        _notes.value = _notes.value?.plus(Note("This is a test note", "Some random value"))
    }


    /**
     * Event Handling
     */
    // Handling create note button click
    private val _createNoteEvent = MutableLiveData<Event<Unit>>()
    val createNoteEvent : LiveData<Event<Unit>>
        get() = _createNoteEvent


    //Handle opening a note
    private val _openNoteEvent = MutableLiveData<Event<Note>>()
    val openNoteEvent: LiveData<Event<Note>>
        get() = _openNoteEvent



    //MARK: aa
    fun createNote() {
        _createNoteEvent.value = Event(Unit)
    }

    fun openNote(note: Note) {
        _openNoteEvent.value = Event(note)
    }

    fun refresh() {
        // Refresh the notes list on change in repository
        if (notes !== NotesRepository.notes) {
            _notes.value = NotesRepository.notes
        }

    }

    fun bookmarkNote(note: Note?) {
        if (note != null) {
            note.isBookmarked = !note.isBookmarked
            updateNoteBookmarkStatus(note!!)

        }


    }

    fun updateNoteBookmarkStatus(note: Note) {
        val index =  _notes.value!!.indexOf(note)
        val tempList = _notes.value!!.toMutableList()
        tempList[index] = note
        _notes.value = tempList

    }



}