package com.example.mymovies.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mymovies.models.MovieSerieDetail

@Dao
interface FavoritsDAO{

    @Insert
    fun insert(movieSerie: DatabaseMovieSerieDetail)

    @Update
    fun update(movieSerie: DatabaseMovieSerieDetail)

    @Query("SELECT * from databasemovieseriedetail WHERE imdbId = :key")
    fun get(key: String): DatabaseMovieSerieDetail?

    @Query("DELETE FROM databasemovieseriedetail")
    fun clear()

    @Query("SELECT * FROM databasemovieseriedetail ORDER BY title DESC")
    fun getAllFavorits(): LiveData<List<DatabaseMovieSerieDetail>>

}