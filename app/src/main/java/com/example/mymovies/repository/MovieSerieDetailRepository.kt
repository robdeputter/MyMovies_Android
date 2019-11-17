package com.example.mymovies.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mymovies.database.MovieSerieFavoritsDatabase
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.asDomainModel
import com.example.mymovies.screens.movieSerie.MovieSerieApiStatus
import com.example.mymovies.screens.search.MyMoviesApiStatus
import kotlinx.coroutines.*

class MovieSerieDetailRepository(){

    private val _movieSerieDetail = MutableLiveData<MovieSerieDetail>()
    val movieSerieDetail: LiveData<MovieSerieDetail>
        get() = _movieSerieDetail;

    private val _status = MutableLiveData<MovieSerieApiStatus>();
    val status : LiveData<MovieSerieApiStatus>
        get() = _status

    private var repositoryJob = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.Main + repositoryJob)

    fun getMovieSerieDetail(imdbId: String){
        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            var getPropertyDeferred = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId)
            try {
                _status.value = MovieSerieApiStatus.LOADING
                // this will run on a thread managed by Retrofit
                val result = getPropertyDeferred.await()
                _status.value = MovieSerieApiStatus.DONE
                _movieSerieDetail.value = result.asDomainModel()
                _status.value = MovieSerieApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MovieSerieApiStatus.ERROR
                _movieSerieDetail.value = null
            }
        }
    }
}