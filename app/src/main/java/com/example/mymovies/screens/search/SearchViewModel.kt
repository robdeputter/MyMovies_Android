package com.example.mymovies.screens.search


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovies.models.MovieSerie
import com.example.mymovies.network.MyMoviesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class MyMoviesApiStatus { LOADING, ERROR, DONE }

class SearchViewModel : ViewModel(){

    private val _status = MutableLiveData<MyMoviesApiStatus>();
    val status : LiveData<MyMoviesApiStatus>
        get() = _status;

    private val _moviesSeries = MutableLiveData<List<MovieSerie>>();
    val movieSerieList : LiveData<List<MovieSerie>>
        get() = _moviesSeries

    private val _navigateToSelectedMovieSerie = MutableLiveData<MovieSerie>()
    val navigateToSelectedMovieSerie : LiveData<MovieSerie>
        get() = _navigateToSelectedMovieSerie

    private val _searchedName = MutableLiveData<String>()
    val searchedName : LiveData<String>
        get() = _searchedName


    private var viewModelJob = Job();

    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main);

    private fun getMoviesSeriesForName(name: String) {
        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            var getMoviesSeriesDeferred = MyMoviesApi.retrofitService.getMovieSeriesForName(name)
            try {
                _status.value = MyMoviesApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                val listResult = getMoviesSeriesDeferred.await()
                _status.value = MyMoviesApiStatus.DONE
                _moviesSeries.value = listResult
            } catch (e: Exception) {
                _status.value = MyMoviesApiStatus.ERROR
                _moviesSeries.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayMovieSerieDetails(movieSerie: MovieSerie){
        _navigateToSelectedMovieSerie.value = movieSerie
    }

    fun displayMovieSerieDetailsComplete(){
        _navigateToSelectedMovieSerie.value = null
    }





}