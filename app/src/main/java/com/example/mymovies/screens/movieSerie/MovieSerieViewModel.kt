package com.example.mymovies.screens.movieSerie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.database.FavoritsDatabase
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.repository.FavoritsRepository
import com.example.mymovies.repository.MovieSerieDetailRepository
import kotlinx.android.synthetic.main.fragment_movie_serie.view.*
import kotlinx.coroutines.*
import java.lang.IllegalArgumentException


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
    val inFavorits : LiveData<Boolean>
        get() = _inFavorits

    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackbarEvent : LiveData<Boolean>
        get() = _showSnackbarEvent


    private var _favoritsAction = MutableLiveData<Boolean>()
    val favoritsAction : LiveData<Boolean>
        get() = _favoritsAction


    private val movieSerieRepository = MovieSerieDetailRepository()
    private val favoritsRepository = FavoritsRepository(FavoritsDatabase.getInstance(application.applicationContext))

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
                _movieSerieDetail.value = movieSerieRepository.getMovieSerieDetail(imdbId) //the movieSerieRepository is responsible for the data
                _status.value = MovieSerieApiStatus.DONE

                inFavorits()
            } catch (e: Exception) {
                _status.value = MovieSerieApiStatus.ERROR
                _movieSerieDetail.value = null
            }
        }
    }

    fun addOrRemoveToFavorits(){
        coroutineScope.launch {
            if(!inFavorits()){
                favoritsRepository.addFavorit(imdbId)
                _showSnackbarEvent.value = true
                _favoritsAction.value = !_favoritsAction.value!!
            }
            else{
                favoritsRepository.removeFavorit(_movieSerieDetail.value!!)
                _showSnackbarEvent.value = true
                _favoritsAction.value = !_favoritsAction.value!!
            }
        }
    }

    private suspend fun inFavorits(): Boolean{
        _inFavorits.value = withContext(Dispatchers.IO){
            var favorit = favoritsRepository.getFavorit(imdbId) != null
            favorit
        }
        _favoritsAction.value = _inFavorits.value //if in favorits ==> true , when star_button pressed ==> removed
        return _inFavorits.value!!
    }

    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = false
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}