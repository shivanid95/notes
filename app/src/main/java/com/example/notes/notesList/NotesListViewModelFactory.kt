package com.example.notes.notesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

/**
 * Instantiates the NotesListViewModel
 */
class NotesListViewModelFactory : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesListViewModel::class.java)) {
            return NotesListViewModel() as T
        }
        throw IllegalArgumentException("Unknown view model calss")
    }

}