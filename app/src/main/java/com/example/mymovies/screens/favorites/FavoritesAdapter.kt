package com.example.mymovies.screens.favorites


import android.nfc.NfcAdapter
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.databinding.FavoriteViewItemBinding
import com.example.mymovies.models.MovieSerieDetail

class FavoritesAdapter(val clickListener: FavoritesListener, val removedListener: RemoveListener):
    ListAdapter<MovieSerieDetail, FavoritesAdapter.ViewHolder>(DiffCallback){


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

    companion object DiffCallback : DiffUtil.ItemCallback<MovieSerieDetail>() {
        override fun areItemsTheSame(oldItem: MovieSerieDetail, newItem: MovieSerieDetail): Boolean {
            return oldItem.imdbID == newItem.imdbID;
        }

        override fun areContentsTheSame(oldItem: MovieSerieDetail, newItem: MovieSerieDetail): Boolean {
            return oldItem == oldItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieSerie = getItem(position)
        holder.bind(movieSerie, clickListener,removedListener)
    }


    class FavoritesListener(val clickListener: (imdbId: String) -> Unit) {
        fun onClick(movieSerie: MovieSerieDetail) = clickListener(movieSerie.imdbID)
    }

    class RemoveListener(val removedListener: (movieSerieDetail : MovieSerieDetail) -> Unit) {
        fun onClick(movieSerie: MovieSerieDetail) = removedListener(movieSerie)
    }
}

