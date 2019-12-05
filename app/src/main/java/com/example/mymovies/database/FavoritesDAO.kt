package com.example.mymovies.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mymovies.models.MovieSerieDetail

/**
 * FavoritesDAO is an interface that provides all the methods that are necessary to manipulate the favorites
 * in the database
 *
 * [Dao] Data Access Objects are the main classes where you define your database interactions. $
 * They can include a variety of query methods.
 */
@Dao
interface FavoritesDAO{

    /**
     * Add a detailed object of a movie or serie to the database.
     * This method is used when you add a movie or serie to your favorites
     */
    @Insert
    fun insert(movieSerie: DatabaseMovieSerieDetail)

    /**
     * Update a detailed object of a movie or serie to the database.
     */
    @Update
    fun update(movieSerie: DatabaseMovieSerieDetail)

    /**
     * Delete a detailed object of a movie or serie to the database.
     * This method is used when you remove a movie or serie from your favorites
     */
    @Delete
    fun delete(movieSerie: DatabaseMovieSerieDetail)

    /**
     * Get a movie or serie by it's imdbId (unique)
     * This method is used when you want to check if a movie or serie is already in your favorites
     */
    @Query("SELECT * from databasemovieseriedetail WHERE imdbId = :key")
    fun get(key: String): DatabaseMovieSerieDetail?

    /**
     * Clear all the favorites from the database
     */
    @Query("DELETE FROM databasemovieseriedetail")
    fun clear()

    /**
     * Get all the favorites
     * This method is used to get an overview of all your favorites
     */
    @Query("SELECT * FROM databasemovieseriedetail ORDER BY favoriteRating DESC")
    fun getAllFavorits(): LiveData<List<DatabaseMovieSerieDetail>>

}