package com.example.mymovies.screens.movieSerie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.database.MovieSerieDAO
import com.example.mymovies.models.MovieSerie
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.network.MyMoviesApi
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

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getMovieSerieDetailObject() {
        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            var getPropertyDeferred = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId)
            try {
                _status.value = MovieSerieApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                val result = getPropertyDeferred.await()
                _status.value = MovieSerieApiStatus.DONE
                _movieSerieDetail.value = result
            } catch (e: Exception) {
                _status.value = MovieSerieApiStatus.ERROR
                _movieSerieDetail.value = null
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    //HIER GAAN WE EEN REQUEST DOEN NAAR DE API OM DIE BEPAALDE FILM OF SERIE TE VERKRIJGEN!!! --> daarna in de databank steken en ophalen

    /* DATABANK
    fun getMovieSerieDetail() {
        uiScope.launch {
            _movieSerie.value = getMovieSerieFromDatabase()
        }
    }

    private suspend fun getMovieSerieFromDatabase(): MovieSerieDetail? {
        return withContext(Dispatchers.IO) {
            var movieSerieDetail = database.get(imdbId);

            movieSerieDetail
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    private suspend fun update(movieSerieDetail: MovieSerieDetail) {
        withContext(Dispatchers.IO) {
            database.update(movieSerieDetail)
        }
    }

    private suspend fun insert(movieSerieDetail: MovieSerieDetail) {
        withContext(Dispatchers.IO) {
            database.insert(movieSerieDetail)
        }
    }
    */


}