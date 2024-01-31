package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.databinding.ItemListBinding

class NoteListAdapter (private val context: Context?):
    DataBoundListAdapter<ItemView, ItemListBinding>(
        diffCallback = object : DiffUtil.ItemCallback<ItemView>() {
            override fun areItemsTheSame(
                oldItemView: ItemView,
                newItemView: ItemView
            ): Boolean {
                return oldItemView.name == newItemView.name
            }

            override fun areContentsTheSame(
                oldItem: ItemView,
                newItem: ItemView
            ): Boolean {
                return oldItem.name == newItem.name
            }
        }
    ) {
//    private val context: Context

    override fun createBinding(parent: ViewGroup): ItemListBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list,
            parent,
            false
        )
    }

    override fun bind(binding: ItemListBinding, item: ItemView, position: Int) {
        binding.apply {

            noteItem = item
//            root.setOnClickListener {
//                noteItem.let {
//                    Log.d("you click on me","yes im work")
//                }
//            }

//            clNoteItem.setOnClickListener {
//                it.findNavController().navigate(R.id.action_homeFragment_to_noteFragment)
//            }
        }
    }

    private var noteItemInfoView: MutableList<ItemView>? = null

    /**
     * can dont override it
     * */

    override fun submitList(list: MutableList<ItemView>?) {
        noteItemInfoView = list
        super.submitList(list)
    }

}