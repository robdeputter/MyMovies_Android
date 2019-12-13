package com.example.mymovies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.database.asDomainModel
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.asDatabaseModel
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.asDatabaseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * Responsible for manipulating and getting favorites
 */
class WatchListRepository(private val _database: MyMoviesDatabase) {

    /**
     * Get all the watchlistEntities that are currently in the database
     *
     * [LiveData] => LiveData is a data holder class that can be observed within a given lifecycle.
     * This means that an {@link Observer} can be added in a pair with a {@link LifecycleOwner}, and
     * this observer will be notified about modifications of the wrapped data only if the paired
     */
    val watchListentities: LiveData<List<MovieSerieDetail>> =
        Transformations.map(_database.watchListDAO.getAllWatchListentities()) {
            it.asDomainModel()
        }

    /**
     * Add a movie / serie to the watchlist
     *
     * [withContext] => Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
     * [Dispatchers.IO] => The [CoroutineDispatcher] that is designed for offloading blocking IO tasks to a shared pool of threads.
     *
     * Why suspend? => you're using [withContext]
     */
    suspend fun addToWatchList(
        imdbId: String
    ) { // bij ophalen van disk --> zeer belangrijk om dit te doen op de IO-thread
        withContext(Dispatchers.IO) {
            if (_database.favoritesDAO.get(imdbId) != null) {
                val result = _database.favoritesDAO.get(imdbId)
                val movieSerieDetail = result!!.asDomainModel()
                movieSerieDetail.inWatchList = true
                _database.watchListDAO.update(movieSerieDetail.asDatabaseModel())
            } else {
                val movieSerieDetail = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId).await()
                movieSerieDetail.inWatchList = true
                _database.watchListDAO.insert(movieSerieDetail.asDatabaseModel())
            }
        }
    }

    /**
     * Get a possible watchListentity by its imdbId
     * @return a possible favorite ( = [MovieSerieDetail])
     *
     * [withContext] => Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
     * [Dispatchers.IO] => The [CoroutineDispatcher] that is designed for offloading blocking IO tasks to a shared pool of threads.
     *
     * Why suspend? => you're using [withContext]
     */
    suspend fun getWatchListentity(imdbId: String): MovieSerieDetail? {
        return withContext(Dispatchers.IO) {
            try {
                val obj = _database.watchListDAO.get(imdbId)!!.asDomainModel()
                obj
            } catch (e: Exception) {
                null
            }
        }
    }

    /**
     * Remove a watchlistentity from the database if it's a favorite, just change the field to false
     *
     * [withContext] => Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
     * [Dispatchers.IO] => The [CoroutineDispatcher] that is designed for offloading blocking IO tasks to a shared pool of threads.
     *
     * Why suspend? => you're using [withContext]
     */
    suspend fun removeWatchListEntity(movieSerieDetail: MovieSerieDetail) {
        withContext(Dispatchers.IO) {
            if (movieSerieDetail.favoriteRating.isNaN()) {
                _database.watchListDAO.delete(movieSerieDetail.asDatabaseModel())
            } else {
                movieSerieDetail.inWatchList = false
                _database.watchListDAO.update(movieSerieDetail.asDatabaseModel())
            }
        }
    }
}