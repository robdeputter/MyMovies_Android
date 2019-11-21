package com.example.mymovies.screens.favorits


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.databinding.FavoritViewItemBinding
import com.example.mymovies.databinding.MovieSerieViewItemBinding
import com.example.mymovies.models.MovieSerie
import com.example.mymovies.models.MovieSerieDetail

class FavoritsAdapter(val clickListener: FavoritsListener):
    ListAdapter<MovieSerieDetail, FavoritsAdapter.ViewHolder>(DiffCallback){


    class ViewHolder private constructor(val binding: FavoritViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: MovieSerieDetail,
            clickListener: FavoritsAdapter.FavoritsListener
        ) {
            binding.movieSerieDetail = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FavoritViewItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieSerieDetail>() {
        override fun areItemsTheSame(oldItem: MovieSerieDetail, newItem: MovieSerieDetail): Boolean {
            return oldItem === newItem;
        }

        override fun areContentsTheSame(oldItem: MovieSerieDetail, newItem: MovieSerieDetail): Boolean {
            return oldItem.imdbID == oldItem.imdbID
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieSerie = getItem(position)
        holder.bind(movieSerie, clickListener)
    }


    class FavoritsListener(val clickListener: (imdbId: String) -> Unit) {
        fun onClick(movieSerie: MovieSerieDetail) = clickListener(movieSerie.imdbID)
    }
}

