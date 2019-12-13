package com.example.mymovies.screens.search

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.databinding.MovieSerieViewItemGridBinding
import com.example.mymovies.models.MovieSerie

/**
 * Responsible for binding each item of the [RecyclerView] that represents the new releases
 */
class MovieSerieAdapter(val clickListener: MovieSerieListener) :
        ListAdapter<MovieSerie, MovieSerieAdapter.ViewHolder>(DiffCallback) {

    /**
     * Describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder private constructor(val binding: MovieSerieViewItemGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: MovieSerie,
            clickListener: MovieSerieAdapter.MovieSerieListener
        ) {
            binding.movieSerie = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieSerieViewItemGridBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    /**
     * Checks if there are different items
     */
    companion object DiffCallback : DiffUtil.ItemCallback<MovieSerie>() {
        override fun areItemsTheSame(oldItem: MovieSerie, newItem: MovieSerie): Boolean {
            return oldItem.imdbID == newItem.imdbID
        }

        override fun areContentsTheSame(oldItem: MovieSerie, newItem: MovieSerie): Boolean {
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
        holder.bind(movieSerie, clickListener)
    }

    /**
     * If an item was clicked, the [MovieSerieListener] sends the imdbId of that item
     */
    class MovieSerieListener(val clickListener: (imdbId: String) -> Unit) {
        fun onClick(movieSerie: MovieSerie) = clickListener(movieSerie.imdbID)
    }
}
