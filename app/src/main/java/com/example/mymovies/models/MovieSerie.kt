package com.example.mymovies.models

/**
 * MovieSerie is a short list of details that describe a movie or serie
 */
data class MovieSerie(
    val imdbID: String,
    val title: String,
    val year: String,
    val type: String,
    val poster: String
)