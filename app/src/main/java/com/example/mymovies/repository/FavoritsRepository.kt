package com.example.mymovies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.mymovies.database.DatabaseMovieSerieDetail
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.database.asDomainModel
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.asDatabaseModel
import com.example.mymovies.network.MyMoviesApi
import com.example.mymovies.network.asDatabaseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * Responsible for manipulating and getting favorites
 */
class FavoritsRepository(private val _database: MyMoviesDatabase) {

    /**
     * Get all the favorites that are currently in the database
     *
     * [LiveData] => LiveData is a data holder class that can be observed within a given lifecycle.
     * This means that an {@link Observer} can be added in a pair with a {@link LifecycleOwner}, and
     * this observer will be notified about modifications of the wrapped data only if the paired
     */
    val favorits: LiveData<List<MovieSerieDetail>> =
        Transformations.map(_database.favoritesDAO.getAllFavorits()) {
            it.asDomainModel()
        }


    /**
     * Add a favorite with its rating to the database
     *
     * [withContext] => Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
     * [Dispatchers.IO] => The [CoroutineDispatcher] that is designed for offloading blocking IO tasks to a shared pool of threads.
     *
     * Why suspend? => you're using [withContext]
     */
    suspend fun addFavorit(
        imdbId: String,
        rating: Float
    ) { // bij ophalen van disk --> zeer belangrijk om dit te doen op de IO-thread
        withContext(Dispatchers.IO) {
            val movieSerieDetail = MyMoviesApi.retrofitService.getMovieSerieDetail(imdbId).await()
            movieSerieDetail.favoriteRating = rating
            _database.favoritesDAO.insert(movieSerieDetail.asDatabaseModel())
        }
    }

    /**
     * Get a possible favorite by its imdbId
     * @return a possible favorite ( = [MovieSerieDetail])
     *
     * [withContext] => Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
     * [Dispatchers.IO] => The [CoroutineDispatcher] that is designed for offloading blocking IO tasks to a shared pool of threads.
     *
     * Why suspend? => you're using [withContext]
     */
    suspend fun getFavorit(imdbId: String): MovieSerieDetail? {
        return withContext(Dispatchers.IO) {
            try {
                val obj =  _database.favoritesDAO.get(imdbId)!!.asDomainModel()
                obj

            } catch (e: Exception) {
                null
            }
        }
    }


    /**
     * Remove a favorite from the database
     *
     * [withContext] => Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
     * [Dispatchers.IO] => The [CoroutineDispatcher] that is designed for offloading blocking IO tasks to a shared pool of threads.
     *
     * Why suspend? => you're using [withContext]
     */
    suspend fun removeFavorit(movieSerieDetail: MovieSerieDetail) {
        withContext(Dispatchers.IO) {
            _database.favoritesDAO.delete(movieSerieDetail.asDatabaseModel())
        }

    }


}