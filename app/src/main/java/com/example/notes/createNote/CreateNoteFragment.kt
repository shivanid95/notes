package com.example.notes.createNote

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.app.SharedElementCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.CreateNoteFragmentBinding


class CreateNoteFragment : Fragment() {

    private lateinit var viewModel: CreateNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This callback will only be called when MyFragment is at least Started.
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
           findNavController().navigate(CreateNoteFragmentDirections.actionCreateNoteFragmentToNotesListFragment2(null,""))
        }

        // The callback can be enabled or disabled here or in the lambda
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<CreateNoteFragmentBinding>(inflater, R.layout.create_note_fragment, container, false)
        binding.setLifecycleOwner(this)

        //Setup ViewModel
        val viewModelFactory = CreateNoteViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(CreateNoteViewModel::class.java)
        binding.viewModel = viewModel
         //Observers
        viewModel.snackbarMessage.observe(this.viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                Toast.makeText(this.context, context?.getString(it), Toast.LENGTH_LONG).show()


            }
        })

        viewModel.saveNoteEvent.observe(this.viewLifecycleOwner, Observer {
            findNavController().navigate(CreateNoteFragmentDirections.actionCreateNoteFragmentToNotesListFragment2(viewModel.title.value, viewModel.content.value ?: ""))
           // findNavController().navigate()
        })
            setHasOptionsMenu(true)
            return binding.root

        }



}