package com.example.mymovies.screens.movieSerie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.repository.FavoritsRepository
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

    private var _inFavorits = MutableLiveData<Boolean>()
    val inFavorits: LiveData<Boolean>
        get() = _inFavorits

    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackbarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent


    private val movieSerieRepository = MovieSerieDetailRepository()
    private val favoritsRepository =
        FavoritsRepository(MyMoviesDatabase.getInstance(application.applicationContext))


    private var job = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)


    init {
        getMovieSerieDetailObject()
    }

    private fun getMovieSerieDetailObject() {
        coroutineScope.launch {
            try {
                _status.value = MovieSerieApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                if (favoritsRepository.getFavorit(imdbId) == null) {
                    _inFavorits.value = false
                    _movieSerieDetail.value =
                        movieSerieRepository.getMovieSerieDetail(imdbId)

                } else {
                    _inFavorits.value = true
                    _movieSerieDetail.value = favoritsRepository.getFavorit(imdbId)
                }
                _status.value = MovieSerieApiStatus.DONE

            } catch (e: Exception) {
                _status.value = MovieSerieApiStatus.ERROR
                _movieSerieDetail.value = null
            }
        }
    }

    fun addToFavorits(rating: Float) {
        coroutineScope.launch {
            favoritsRepository.addFavorit(imdbId, rating)
            _showSnackbarEvent.value = true

            //reloading
            getMovieSerieDetailObject()
        }
    }

    fun removeFromFavorits() {
        coroutineScope.launch {
            favoritsRepository.removeFavorit(_movieSerieDetail.value!!)
            _showSnackbarEvent.value = true
            //reloading
            getMovieSerieDetailObject()
        }
    }


    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = false
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}