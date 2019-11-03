package com.example.mymovies.screens.movieSerie

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymovies.database.MovieSerieDAO

class MovieSerieViewModelFactory(
    private val dataSource: MovieSerieDAO,
    private val application: Application,
    private val imdbId: String
) : ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieSerieViewModel::class.java)) {
            return MovieSerieViewModel(dataSource, imdbId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}