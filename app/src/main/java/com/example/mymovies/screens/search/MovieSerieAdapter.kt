package com.example.mymovies.screens.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.databinding.MovieSerieViewItemBinding
import com.example.mymovies.models.MovieSerie

class MovieSerieAdapter(val clickListener: MovieSerieListener):
        ListAdapter<MovieSerie, MovieSerieAdapter.ViewHolder>(DiffCallback){


    class ViewHolder private constructor(val binding: MovieSerieViewItemBinding) :
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
                val binding = MovieSerieViewItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieSerie>() {
        override fun areItemsTheSame(oldItem: MovieSerie, newItem: MovieSerie): Boolean {
            return oldItem === newItem;
        }

        override fun areContentsTheSame(oldItem: MovieSerie, newItem: MovieSerie): Boolean {
            return oldItem.imdbId == oldItem.imdbId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieSerie = getItem(position)
        holder.bind(movieSerie, clickListener)
    }


    class MovieSerieListener(val clickListener: (imdbId: String) -> Unit) {
        fun onClick(movieSerie: MovieSerie) = clickListener(movieSerie.imdbId)
    }
}

