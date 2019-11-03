package com.example.mymovies.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mymovies.screens.MovieSerie.models.MovieSerieDetail

@Dao
interface MovieSerieDAO{

    @Insert
    fun insert(movieSerie: MovieSerieDetail)

    @Update
    fun update(movieSerie: MovieSerieDetail)

    @Query("SELECT * from movie_serie_detail WHERE imdbId = :key")
    fun get(key: String): MovieSerieDetail?

    @Query("DELETE FROM movie_serie_detail")
    fun clear()

    @Query("SELECT * FROM movie_serie_detail ORDER BY title DESC")
    fun getAllMoviesSeries(): LiveData<List<MovieSerieDetail>>

}