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

        val data = listOf(
            Note("First npte", "Dummy content"),
            Note("Hello world", "This is a note"),
            Note("YOlo", "You only live once")

        )
        binding.setLifecycleOwner(this)
        val viewModelFactory = NotesListViewModelFactory()
        val adaptor = NotesListAdaptor()
        binding.notesList.adapter = adaptor

        viewModel = ViewModelProvider(this, viewModelFactory).get(NotesListViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.notes.observe(this, Observer {newNotes ->
            adaptor.submitList(newNotes)
        })

        binding.notesList.layoutManager = LinearLayoutManager(this.context)

        viewModel.createNoteEvent.observe(this, Observer {
            //TODO: Redirect to create notes
            viewModel.add()
            findNavController().navigate(NotesListFragmentDirections.actionNotesListFragmentToCreateNoteFragment())
           // findNavController().navigate()
        })


        return binding.root


    }
}