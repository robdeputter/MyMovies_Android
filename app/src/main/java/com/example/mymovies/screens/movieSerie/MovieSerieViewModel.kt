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






    private val movieSerieRepository = MovieSerieDetailRepository()
    private val favoritsRepository = FavoritsRepository(FavoritsDatabase.getInstance(application.applicationContext))

    private var job = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    private var _inFavorits = MutableLiveData<Boolean>()
    val inFavorits : LiveData<Boolean>
        get() = _inFavorits


    fun getMovieSerieDetailObject() {
        coroutineScope.launch {
            try {
                _status.value = MovieSerieApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                _movieSerieDetail.value = movieSerieRepository.getMovieSerieDetail(imdbId) //the movieSerieRepository is responsible for the data
                _status.value = MovieSerieApiStatus.DONE
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
            }
            else{
                favoritsRepository.removeFavorit(_movieSerieDetail.value!!)
            }
        }
    }

    private suspend fun inFavorits(): Boolean{
        _inFavorits.value = withContext(Dispatchers.IO){
            var favorit = favoritsRepository.getFavorit(imdbId) != null
            favorit
        }
        return _inFavorits.value!!
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}