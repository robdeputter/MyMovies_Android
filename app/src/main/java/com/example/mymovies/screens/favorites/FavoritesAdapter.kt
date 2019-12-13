package com.example.mymovies.screens.favorites

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.databinding.FavoriteViewItemBinding
import com.example.mymovies.models.MovieSerieDetail

/**
 * Responsible for binding each item of the [RecyclerView] that represents the favorites
 */
class FavoritesAdapter(val clickListener: FavoritesListener, val removedListener: RemoveListener) :
    ListAdapter<MovieSerieDetail, FavoritesAdapter.ViewHolder>(DiffCallback) {

    /**
     * Describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder private constructor(val binding: FavoriteViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: MovieSerieDetail,
            clickListener: FavoritesListener,
            removedListener: RemoveListener
        ) {
            binding.movieSerieDetail = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
            binding.removeClickListener = removedListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FavoriteViewItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    /**
     * Checks if there are different items
     */
    companion object DiffCallback : DiffUtil.ItemCallback<MovieSerieDetail>() {
        override fun areItemsTheSame(oldItem: MovieSerieDetail, newItem: MovieSerieDetail): Boolean {
            return oldItem.imdbID == newItem.imdbID
        }

        override fun areContentsTheSame(oldItem: MovieSerieDetail, newItem: MovieSerieDetail): Boolean {
            return oldItem == oldItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    /**
     * Binds each item
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieSerie = getItem(position)
        holder.bind(movieSerie, clickListener, removedListener)
    }

    /**
     * If an item was clicked, the FavoritesListener sends the imdbId of that item
     */
    class FavoritesListener(val clickListener: (imdbId: String) -> Unit) {
        fun onClick(movieSerie: MovieSerieDetail) = clickListener(movieSerie.imdbID)
    }

    /**
     * If an item is clicked, the RemoveListener sends the [MovieSerieDetail] object of that item
     */
    class RemoveListener(val removedListener: (movieSerieDetail: MovieSerieDetail) -> Unit) {
        fun onClick(movieSerie: MovieSerieDetail) = removedListener(movieSerie)
    }
}
