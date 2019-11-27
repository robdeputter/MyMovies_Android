package com.example.mymovies.models

import com.example.mymovies.network.NetworkNewRelease
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewReleaseResponse(
    val COUNT : String,
    val ITEMS: List<NetworkNewRelease>
)