package com.example.notes.noteDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.data.Note
import com.example.notes.databinding.NoteDetailsFragmentBinding

class NoteDetailsFragment(val note: Note): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<NoteDetailsFragmentBinding>(inflater, R.layout.note_details_fragment, container, false)
        binding.note = note
        return binding.root
    }


}