package com.example.mymovies.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mymovies.models.MovieSerieDetail

@Dao
interface FavoritesDAO{

    @Insert
    fun insert(movieSerie: DatabaseMovieSerieDetail)

    @Update
    fun update(movieSerie: DatabaseMovieSerieDetail)

    @Delete
    fun delete(movieSerie: DatabaseMovieSerieDetail)

    @Query("SELECT * from databasemovieseriedetail WHERE imdbId = :key")
    fun get(key: String): DatabaseMovieSerieDetail?

    @Query("DELETE FROM databasemovieseriedetail")
    fun clear()

    @Query("SELECT * FROM databasemovieseriedetail ORDER BY title ASC")
    fun getAllFavorits(): LiveData<List<DatabaseMovieSerieDetail>>

}