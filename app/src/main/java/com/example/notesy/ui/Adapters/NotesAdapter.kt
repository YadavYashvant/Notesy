package com.example.notesy.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notesy.databinding.ItemNoteBinding
import com.example.notesy.model.Notes
import com.example.notesy.ui.Fragments.HomeFragmentDirections

class NotesAdapter(val requireContext: Context, val notesList: List<Notes>, colorList: List<Int>) : RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {

    class notesViewHolder(val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {

        return notesViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false
            ))
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.notesTitle.text = data.title
        holder.binding.notesSubtitle.text = data.subtitle
        holder.binding.notesDate.text = data.date

        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(data)
            Navigation.findNavController(it).navigate(action)
        }
    }

}