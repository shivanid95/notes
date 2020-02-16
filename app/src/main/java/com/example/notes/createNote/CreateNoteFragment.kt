package com.example.notes.createNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.databinding.CreateNoteFragmentBinding

class CreateNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<CreateNoteFragmentBinding>(inflater, R.layout.create_note_fragment, container, false)
        setHasOptionsMenu(true)
        return binding.root

    }
}