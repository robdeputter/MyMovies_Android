package com.example.mymovies.screens.watchlist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymovies.database.MyMoviesDatabase

/**
 * Responsible for creating a [FavoritesViewModel] instance
 */
class WatchlistViewModelFactory(
    val application: Application,
    val database: MyMoviesDatabase
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WatchlistViewModel::class.java)) {
            return WatchlistViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}