package com.example.mymovies.screens.favorits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymovies.screens.MovieSerie.MovieSerieViewModel

class  FavoritsViewModelFactory : ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritsViewModel::class.java)) {
            return FavoritsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}