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

    private var job = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    val favoritsList = movieSerieRepository.favorits
}