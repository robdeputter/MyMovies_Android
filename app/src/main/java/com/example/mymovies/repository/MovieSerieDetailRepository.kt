package com.example.mymovies.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.asDomainModel
import com.example.mymovies.screens.movieSerie.MovieSerieApiStatus

class MovieSerieDetailRepository(){


    private val _status = MutableLiveData<MovieSerieApiStatus>();
    val status : LiveData<MovieSerieApiStatus>
        get() = _status



    suspend fun getMovieSerieDetail(imdbId: String) : MovieSerieDetail?{
        // Get the Deferred object for our Retrofit request
        var getPropertyDeferred = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId)

        // this will run on a thread managed by Retrofit
        val result = getPropertyDeferred.await()
        return result.asDomainModel()

    }
}