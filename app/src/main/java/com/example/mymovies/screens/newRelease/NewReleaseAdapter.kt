package com.example.mymovies.screens.newRelease

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.databinding.NewReleaseItemGridBinding
import com.example.mymovies.models.NewRelease

/**
 * Responsible for binding each item of the [RecyclerView] that represents the new releases
 */
class NewReleaseAdapter(val clickListener: NewReleaseListener) :
    ListAdapter<NewRelease, NewReleaseAdapter.ViewHolder>(DiffCallback) {

    /**
     * Describes an item view and metadata about its place within the RecyclerView.
     */
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

    /**
     * Checks if there are different items
     */
    companion object DiffCallback : DiffUtil.ItemCallback<NewRelease>() {
        override fun areItemsTheSame(oldItem: NewRelease, newItem: NewRelease): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: NewRelease, newItem: NewRelease): Boolean {
            return oldItem.imdbID == oldItem.imdbID
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    /**
     * Binds each item
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newRelease = getItem(position)
        holder.bind(newRelease, clickListener)
    }

    /**
     * If an item was clicked, the NewReleaseListener sends the imdbId of that item
     */
    class NewReleaseListener(val clickListener: (imdbId: String) -> Unit) {
        fun onClick(newRelease: NewRelease) = clickListener(newRelease.imdbID)
    }
}