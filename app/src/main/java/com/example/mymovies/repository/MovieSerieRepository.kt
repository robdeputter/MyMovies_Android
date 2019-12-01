package com.example.mymovies.repository

import com.example.mymovies.models.MovieSerie
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.asDomainModel_MovieSerie

class MovieSerieRepository {


    suspend fun getMovieSeriesByFilter(name: String, year: String? , type : String?) : List<MovieSerie>{
        // Get the Deferred object for our Retrofit requestw

        var getPropertyDeferred = MyMoviesApi.retrofitService.getMovieSeriesForName(name, year, type)

        // this will run on a thread managed by Retrofit
        val result = getPropertyDeferred.await()
        return result.Search.asDomainModel_MovieSerie()

    }
}