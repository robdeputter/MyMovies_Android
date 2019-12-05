package com.example.mymovies.models

/**
 * NewRelease is a list of details that describe of new release (on Netflix)
 */
data class NewRelease(
    val imdbID: String,
    val title: String,
    val released: String?,
    val type: String,
    val image: String?
)