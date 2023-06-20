package com.example.notesy.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.notesy.R
import com.example.notesy.ViewModel.NotesViewModel
import com.example.notesy.databinding.FragmentCreateNoteBinding
import com.example.notesy.model.Notes
import java.util.Date

class CreateNoteFragment : Fragment() {

    lateinit var binding: FragmentCreateNoteBinding
    val viewModel : NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCreateNoteBinding.inflate(layoutInflater,container,false)

        binding.fbtnsaveNote.setOnClickListener {
            creatNotes(it)
        }

        return binding.root
    }

    private fun creatNotes(it: View?) {

        val title = binding.edtTitle.text.toString()
        val subtitle = binding.edtSubtitle.text.toString()
        val notes = binding.edtNote.text.toString()

        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes(null, title = title,subtitle = subtitle,
            notes = notes,
            date = notesDate.toString()
            )
        viewModel.addNotes(data)

        Toast.makeText(requireContext(),"Note Created",Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_homeFragment)
    }

}