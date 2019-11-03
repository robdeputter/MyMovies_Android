package com.example.mymovies.screens.MovieSerie.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_serie_short")
data class MovieSerie(
    @PrimaryKey(autoGenerate = true)
    val imdbId: String,

    val title: String,
    val year: Int,
    val type: String,
    val poster: String
)