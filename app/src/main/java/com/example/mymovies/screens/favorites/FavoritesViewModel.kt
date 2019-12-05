package com.example.mymovies.screens.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.DatabaseMovieSerieDetail
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.repository.FavoritsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FavoritesViewModel(val database: MyMoviesDatabase) : ViewModel(){

    private val movieSerieRepository = FavoritsRepository(database)

    val favoritesList = movieSerieRepository.favorits

    private var job = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)


    private val _navigateToSelectedMovieSerie = MutableLiveData<String>()
    val navigateToSelectedMovieSerie : LiveData<String>
        get() = _navigateToSelectedMovieSerie


    fun displayMovieSerieDetails(imdbId: String){
        _navigateToSelectedMovieSerie.value = imdbId
    }

    fun displayMovieSerieDetailsComplete(){
        _navigateToSelectedMovieSerie.value = null
    }

    fun removeFromFavorites(movieSerieDetail: MovieSerieDetail){
        coroutineScope.launch {
            movieSerieRepository.removeFavorit(movieSerieDetail)
        }

    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}