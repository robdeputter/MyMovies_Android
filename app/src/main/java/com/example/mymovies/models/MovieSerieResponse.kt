package com.example.mymovies.models

import com.example.mymovies.network.NetworkMovieSerie

data class MovieSerieResponse(
    val Search: List<NetworkMovieSerie>,
    val totalResults: String?,
    val Response: String

)