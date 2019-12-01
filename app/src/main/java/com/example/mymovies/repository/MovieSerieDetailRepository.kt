package com.example.mymovies.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.MyMoviesApiService
import com.example.mymovies.network.asDomainModel
import com.example.mymovies.screens.search.MyMoviesApiStatus


class MovieSerieDetailRepository(){

    suspend fun getMovieSerieDetail(imdbId: String) : MovieSerieDetail?{
        // Get the Deferred object for our Retrofit request
        var getPropertyDeferred = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId)

        return getPropertyDeferred.await().asDomainModel()
    }
}