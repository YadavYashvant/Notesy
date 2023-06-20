package com.example.notesy.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notesy.R
import com.example.notesy.databinding.FragmentCreateNoteBinding

class CreateNoteFragment : Fragment() {

    lateinit var binding: FragmentCreateNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCreateNoteBinding.inflate(layoutInflater,container,false)



        return binding.root
    }

}