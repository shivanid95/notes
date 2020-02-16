package com.example.notes.notesList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.R
import com.example.notes.databinding.NotesListFragmentBinding

class NotesListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<NotesListFragmentBinding>(
            inflater,
            R.layout.notes_list_fragment,
            container,
            false
        )

        binding.notesList.adapter = NotesListAdaptor()
        binding.notesList.layoutManager = LinearLayoutManager(this.context)
        return binding.root

    }
}