package com.example.mymovies.repository

import com.example.mymovies.models.MovieSerie
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.asDomainModel_MovieSerie

class MovieSerieRepository {


    suspend fun getMovieSeriesByFilter(name: String, year: String? , type : String?) : List<MovieSerie>?{
        // Get the Deferred object for our Retrofit requestw
        var getPropertyDeferred = MyMoviesApi.retrofitService.getMovieSeriesForName(name, year, type)

        return getPropertyDeferred.await().Search.asDomainModel_MovieSerie()
    }
}