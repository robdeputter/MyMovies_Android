package com.example.mymovies.models

import com.example.mymovies.network.NetworkNewRelease
import com.squareup.moshi.JsonClass

/**
 * NewReleaseResponse corresponds to the data that you get from the uNoGS-network
 * (uNoGS = unofficial Netflix online Global Search)
 */
@JsonClass(generateAdapter = true)
data class NewReleaseResponse(
    val COUNT : String,
    val ITEMS: List<NetworkNewRelease>
)