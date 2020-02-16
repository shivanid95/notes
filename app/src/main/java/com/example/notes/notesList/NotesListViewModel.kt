package com.example.notes.notesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.notes.data.Note


class NotesListViewModel : ViewModel() {

   // List of notes added
    val _notes = MutableLiveData<List<Note>>().apply { value = emptyList() }
    val notes: LiveData<List<Note>>
        get() = _notes

    // Live data depending on notes list, returns true if list is empty
    val isListEmpty: LiveData<Boolean> = Transformations.map(_notes) { it.isEmpty()}


}