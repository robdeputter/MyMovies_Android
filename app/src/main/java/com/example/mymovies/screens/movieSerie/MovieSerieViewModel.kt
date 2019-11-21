package com.example.mymovies.screens.movieSerie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.repository.MovieSerieDetailRepository
import kotlinx.coroutines.*


enum class MovieSerieApiStatus { LOADING, ERROR, DONE }

class MovieSerieViewModel(
    val imdbId: String,
    private val application: Application
) : ViewModel() {

    private val _status = MutableLiveData<MovieSerieApiStatus>();
    val status: LiveData<MovieSerieApiStatus>
        get() = _status

    private var _movieSerieDetail = MutableLiveData<MovieSerieDetail>()
    val movieSerie: LiveData<MovieSerieDetail>
        get() = _movieSerieDetail;


    private val movieSerieRepository = MovieSerieDetailRepository()

    private var job = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    fun getMovieSerieDetailObject() {
        coroutineScope.launch {
            try {
                _status.value = MovieSerieApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                _movieSerieDetail.value = movieSerieRepository.getMovieSerieDetail(imdbId)
                _status.value = MovieSerieApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MovieSerieApiStatus.ERROR
                _movieSerieDetail.value = null
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }


}