package com.example.mymovies.models

data class NewRelease(
    val imdbID: String,
    val title: String,
    val released: String?,
    val type: String,
    val image: String?
)