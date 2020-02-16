package com.example.notes.createNote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.R
import com.example.notes.data.Note
import com.example.notes.data.NotesRepository
import com.example.notes.utility.Event

class CreateNoteViewModel: ViewModel() {

    // Two-way databinding, exposing MutableLiveData
    val title = MutableLiveData<String>()

    // Two-way databinding, exposing MutableLiveData
    val content = MutableLiveData<String>()

    private val _saveNoteEvent = MutableLiveData<Event<Unit>>()
    val saveNoteEvent: LiveData<Event<Unit>>
        get() = _saveNoteEvent


    private val _snackbarText = MutableLiveData<Event<Int>>()
    val snackbarMessage: LiveData<Event<Int>>
        get() = _snackbarText


    val canSaveNote : Boolean
        get() {
            return isTitleValid && isContentValid
        }

    val isTitleValid: Boolean
        get() {
            val titleStr = title.value
            return !titleStr.isNullOrEmpty() && titleStr.length <= 100
        }

    val isContentValid: Boolean
        get() {
            val contentString = content.value
            return !contentString.isNullOrEmpty()
        }



    fun saveNote() {
        Log.d("Content", "${title.value} content: ${content.value}")
        if (canSaveNote) {
            val note = Note(title.value!!, content.value!!)
            _saveNoteEvent.value = Event(Unit)
            NotesRepository.add(note)
        }
        else if (!isTitleValid) {
                _snackbarText.value = Event(R.string.no_title_message)
            }

        else if (!isContentValid) {
            _snackbarText.value = Event(R.string.no_content_message)

        }

    }
}