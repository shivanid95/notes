package com.example.notes.noteDetails

import android.os.Bundle
import android.text.format.DateFormat
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.createNote.CreateNoteFragmentDirections
import com.example.notes.data.Note
import com.example.notes.databinding.NoteDetailsFragmentBinding
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class NoteDetailsFragment: Fragment() {

   lateinit var note: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // Handle back press
          requireActivity().onBackPressedDispatcher.addCallback(this) {
          findNavController().navigate(NoteDetailsFragmentDirections.actionNoteDetailsFragmentToNotesListFragment(null, ""))
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<NoteDetailsFragmentBinding>(inflater, R.layout.note_details_fragment, container, false)
        arguments?.let {

            val noteObject = it.getParcelable("note") as Note
            print(noteObject)
            note = noteObject
        }
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.note = note
        binding.noteCreationDateText.text = "Created on ${getDateString(note.date)}"
        setHasOptionsMenu(true)

        //Set Background color
        binding.root.setBackgroundColor(getResources().getColor(R.color.colorBackground))
        return binding.root
    }


    fun getDateString(date: Date):  String {
        val format = SimpleDateFormat("MMM dd, yyyy")
        return format.format(date)


    }


}