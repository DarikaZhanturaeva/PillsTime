package com.example.pillstime.ui.fragments.green_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pillstime.data.local.entity.model.PillsModel
import com.example.pillstime.databinding.ItemPillsBinding

class PillsGreenAdapter () :
    ListAdapter<PillsModel, PillsGreenAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPillsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class ViewHolder(private val binding: ItemPillsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(noteModel: PillsModel?) {
            binding.apply {
                tvTime.text = noteModel?.time
                tvTitle.text = noteModel?.title
                tvDescription.text = noteModel?.description
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<PillsModel>() {
        override fun areItemsTheSame(oldItem: PillsModel, newItem: PillsModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PillsModel, newItem: PillsModel): Boolean {
            return oldItem.id == newItem.id
        }
    }
}