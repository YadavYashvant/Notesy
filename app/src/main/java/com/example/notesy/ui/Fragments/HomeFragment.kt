package com.example.notesy.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notesy.R
import com.example.notesy.ViewModel.NotesViewModel
import com.example.notesy.databinding.FragmentHomeBinding
import com.example.notesy.ui.Adapters.NotesAdapter

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        viewModel.getNotes().observe(viewLifecycleOwner,{ notesList ->

            binding.RvHome.layoutManager = GridLayoutManager(requireContext(),2);
            binding.RvHome.adapter = NotesAdapter(requireContext(),notesList)
        })

        binding.Homeaddlbtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNoteFragment)
        }

        return binding.root
    }

}