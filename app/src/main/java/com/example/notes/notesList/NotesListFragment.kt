package com.example.notes.notesList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.R
import com.example.notes.createNote.CreateNoteFragment
import com.example.notes.data.Note
import com.example.notes.databinding.NotesListFragmentBinding


class NotesListFragment : Fragment() {

    lateinit var viewModel: NotesListViewModel
    lateinit var listAdapter: NotesListAdaptor



    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }

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

        binding.setLifecycleOwner(this)
        binding.root.setBackgroundColor(getResources().getColor(R.color.colorBackground))
        val viewModelFactory = NotesListViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(NotesListViewModel::class.java)
        binding.viewModel = viewModel

        listAdapter = NotesListAdaptor(viewModel)
        binding.notesList.adapter = listAdapter

        viewModel.notes.observe(this.viewLifecycleOwner, Observer {newNotes ->
            listAdapter.submitList(newNotes)
        })

        binding.notesList.layoutManager = LinearLayoutManager(this.context)

        viewModel.createNoteEvent.observe(this.viewLifecycleOwner, Observer {

            findNavController().navigate(NotesListFragmentDirections.actionNotesListFragmentToCreateNoteFragment())

        })


        viewModel.openNoteEvent.observe(this.viewLifecycleOwner, Observer {
            val note = it.peekContent()
            findNavController().navigate(NotesListFragmentDirections.actionNotesListFragmentToNoteDetailsFragment(note))
           // findNavController().navigate(NotesListFragmentDirections.)
            //findNavController().navigate(NotesListFragmentDirections)
        })

        return binding.root


    }
}