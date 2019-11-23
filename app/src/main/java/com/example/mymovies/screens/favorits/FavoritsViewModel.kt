package com.example.mymovies.screens.favorits

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.FavoritsDatabase
import com.example.mymovies.models.MovieSerie
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.repository.FavoritsRepository
import com.example.mymovies.repository.MovieSerieDetailRepository
import com.example.mymovies.screens.movieSerie.MovieSerieApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FavoritsViewModel(val database: FavoritsDatabase) : ViewModel(){

    private val movieSerieRepository = FavoritsRepository(database)

    val favoritsList = movieSerieRepository.favorits


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