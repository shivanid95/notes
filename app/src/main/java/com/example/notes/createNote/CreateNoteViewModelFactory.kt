package com.example.notes.createNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CreateNoteViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CreateNoteViewModel::class.java)) {
            return CreateNoteViewModel() as T
        }

        throw IllegalArgumentException("Unknown view model calss")
    }

}