package com.example.mymovies.models


import android.os.Parcel
import android.os.Parcelable

import kotlinx.android.parcel.Parcelize


data class MovieSerieDetail(
    val imdbId: String,
    val Title: String,
    val Year: String,
    val Type: String,
    val Poster: String,
    val Released: String,
    val RunTime: String,
    val Genre: String,
    val Actors: String,
    val imdbRating: String,
    val imdbVotes: String)