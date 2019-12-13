package com.example.mymovies.repository

import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.asDomainModel

/**
 * Responsible for getting [MovieSerieDetail] objects
 */
class MovieSerieDetailRepository {

    /**
     * Get a MovieSerieDetail through a network call
     * @return possible [MovieSerieDetail] object (if imdbId is unknown in the back-end => null)
     *
     * Why suspend? = you're calling an await() function on the [Deferred] object
     */
    suspend fun getMovieSerieDetail(imdbId: String): MovieSerieDetail? {

        var getPropertyDeferred = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId)

        return getPropertyDeferred.await().asDomainModel()
    }
}