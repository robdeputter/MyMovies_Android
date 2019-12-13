package com.example.mymovies.database

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * FavoritesDAO is an interface that provides all the methods that are necessary to manipulate the movies / series you want to watch
 * in the database
 *
 * [Dao] Data Access Objects are the main classes where you define your database interactions. $
 * They can include a variety of query methods.
 */
@Dao
interface WatchListDAO {

    /**
     * Add a detailed object of a movie or serie to the database.
     * This method is used when you add a movie or serie to your watchlist
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieSerie: DatabaseMovieSerieDetail)

    /**
     * Update a detailed object of a movie or serie to the database.
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(movieSerie: DatabaseMovieSerieDetail)

    /**
     * Delete a detailed object of a movie or serie to the database.
     * This method is used when you remove a movie or serie from your watchlist
     */
    @Delete
    fun delete(movieSerie: DatabaseMovieSerieDetail)

    /**
     * Get a movie or serie by it's imdbId (unique)
     * This method is used when you want to check if a movie or serie is already in your watchlist
     */
    @Query("SELECT * from databasemovieseriedetail WHERE imdbId = :key AND inWatchList = 1")
    fun get(key: String): DatabaseMovieSerieDetail?

    /**
     * Clear all the watchlistentities from the database
     */
    @Query("DELETE FROM databasemovieseriedetail")
    fun clear()

    /**
     * Get all the watchlistentities
     * This method is used to get an overview of all your watchlistentities
     */
    @Query("SELECT * FROM databasemovieseriedetail WHERE inWatchList = 1 ORDER BY title DESC")
    fun getAllWatchListentities(): LiveData<List<DatabaseMovieSerieDetail>>
}