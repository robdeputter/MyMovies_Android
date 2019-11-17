package com.example.mymovies.models


import android.os.Parcel
import android.os.Parcelable

import kotlinx.android.parcel.Parcelize


data class MovieSerieDetail(
    val imdbID: String,
    val title: String,
    val year: String,
    val type: String,
    val poster: String,
    val released: String,
    val runTime: String?,
    val genre: String,
    val actors: String,
    val imdbRating: String,
    val imdbVotes: String)