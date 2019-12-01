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
        // Get the Deferred object for our Retrofit requestw

        var getPropertyDeferred = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId)

        // this will run on a thread managed by Retrofit
        val result = getPropertyDeferred.await()
        return result.asDomainModel()

    }
}