package com.example.notes.notesList

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.notes.data.Note
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
    private val _openNoteEvent = MutableLiveData<Event<Unit>>()
    val openNoteEvent: LiveData<Event<Unit>>
        get() = _openNoteEvent



    //MARK: aa
    fun createNote() {
        _createNoteEvent.value = Event(Unit)
    }

    fun openNote() {
        _openNoteEvent.value = Event(Unit)
    }



}