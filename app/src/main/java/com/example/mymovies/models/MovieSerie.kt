package com.example.mymovies.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


data class MovieSerie(
    val imdbID: String,
    val Title: String,
    val Year: String,
    val Type: String,
    val Poster: String)
