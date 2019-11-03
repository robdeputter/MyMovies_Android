package com.example.mymovies.screens.movieSerie.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_serie_detail")
data class MovieSerieDetail(
    @PrimaryKey
    val imdbId: String,
    val title: String,
    val year: Int,
    val type: String,
    val poster: String?,
    val released: String,
    val runTime: String,
    val genre: String,
    val actors: String,
    val ratings: Array<Rating>?,
    val imdbRating: Double,
    val imdbVotes: Int
)