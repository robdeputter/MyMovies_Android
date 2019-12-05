package com.example.mymovies.screens.newRelease

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.databinding.NewReleaseItemBinding
import com.example.mymovies.databinding.NewReleaseItemGridBinding
import com.example.mymovies.models.NewRelease

class NewReleaseAdapter(val clickListener: NewReleaseListener):
    ListAdapter<NewRelease, NewReleaseAdapter.ViewHolder>(DiffCallback){

    class ViewHolder private constructor(val binding: NewReleaseItemGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: NewRelease,
            clickListener: NewReleaseListener
        ) {
            binding.newRelease = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NewReleaseItemGridBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<NewRelease>() {
        override fun areItemsTheSame(oldItem: NewRelease, newItem: NewRelease): Boolean {
            return oldItem === newItem;
        }

        override fun areContentsTheSame(oldItem: NewRelease, newItem: NewRelease): Boolean {
            return oldItem.imdbID == oldItem.imdbID
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newRelease = getItem(position)
        holder.bind(newRelease, clickListener)
    }

    class NewReleaseListener(val clickListener: (imdbId: String) -> Unit) {
        fun onClick(newRelease: NewRelease) = clickListener(newRelease.imdbID)
    }


}