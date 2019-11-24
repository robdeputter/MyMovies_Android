package com.example.mymovies.models

import com.example.mymovies.network.NetworkNewRelease
import com.example.mymovies.network.NetworkNewReleases

data class NewReleaseResponse(
    val ITEMS: NetworkNewReleases
)