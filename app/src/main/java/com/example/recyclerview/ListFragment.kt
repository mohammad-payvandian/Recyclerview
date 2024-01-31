package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.recyclerview.databinding.FragmentListBinding


class ListFragment : Fragment() {

     var adapter: NoteListAdapter = NoteListAdapter(context)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val binding: FragmentListBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false)

        adapter.submitList(mutableListOf(
            ItemView("mohamad",""),
            ItemView("mozhgan",""),
            ItemView("maman",""),
            ItemView("baba",""),
            ItemView("hadi",""),
            ItemView("eshghe mohamad","")
        ))

        binding.noteList.adapter = adapter


        return binding.root

    }
}