package com.example.notes.createNote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.R
import com.example.notes.data.Note
import com.example.notes.data.NotesRepository
import com.example.notes.utility.Event

/**
 * CreateNoteViewModel handles business logic for note creation.
 */
class CreateNoteViewModel: ViewModel() {

    /**
     * Data Bindings
     */

    // Two-way databinding, exposing MutableLiveData
    val title = MutableLiveData<String>()

    // Two-way databinding, exposing MutableLiveData
    val content = MutableLiveData<String>()

    // Live on Click event emitter for saving notes
    private val _saveNoteEvent = MutableLiveData<Event<Unit>>()
    val saveNoteEvent: LiveData<Event<Unit>>
        get() = _saveNoteEvent

    // Show Snackbar event emitter (when save cannot be performed)
    private val _snackbarText = MutableLiveData<Event<Int>>()
    val snackbarMessage: LiveData<Event<Int>>
        get() = _snackbarText

    /**
     * Utility Variables
     */

    // Returns true if content and title are not empty
    val canSaveNote : Boolean
        get() {
            return isTitleValid && isContentValid
        }

    // Returns true if title is not emoty and number of characters are less than 100
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


    // Adds note to the notes Repository
    fun saveNote() {
        Log.d("Content", "${title.value} content: ${content.value}")
        if (canSaveNote) {
            val note = Note(title.value!!, content.value!!)
            NotesRepository.add(note)
            // Emits snackbar event
            _saveNoteEvent.value = Event(Unit)

        }
        else if (!isTitleValid) {
            // Emits snackbar event
            _snackbarText.value = Event(R.string.no_title_message)
        }

        else if (!isContentValid) {
            _snackbarText.value = Event(R.string.no_content_message)

        }

    }
}