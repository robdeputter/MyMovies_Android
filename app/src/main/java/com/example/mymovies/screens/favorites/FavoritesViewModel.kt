package com.example.mymovies.screens.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.repository.FavoritsRepository

class FavoritesViewModel(val database: MyMoviesDatabase) : ViewModel(){

    private val movieSerieRepository = FavoritsRepository(database)

    val favoritesList = movieSerieRepository.favorits


    private val _navigateToSelectedMovieSerie = MutableLiveData<String>()
    val navigateToSelectedMovieSerie : LiveData<String>
        get() = _navigateToSelectedMovieSerie


    fun displayMovieSerieDetails(imdbId: String){
        _navigateToSelectedMovieSerie.value = imdbId
    }

    fun displayMovieSerieDetailsComplete(){
        _navigateToSelectedMovieSerie.value = null
    }

    override fun onCleared() {
        super.onCleared()
    }
}