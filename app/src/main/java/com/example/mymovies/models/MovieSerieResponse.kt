package com.example.mymovies.models

import com.example.mymovies.network.NetworkMovieSerie

/**
 * MovieSerieResponse corresponds to the data that you get from imdb-network
 */
data class MovieSerieResponse(
    val Search: List<NetworkMovieSerie>,
    val totalResults: String?,
    val Response: String
)