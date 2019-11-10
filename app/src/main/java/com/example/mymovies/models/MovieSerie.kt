package com.example.mymovies.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


data class MovieSerie(
    val imdbId: String,
    val Title: String,
    val Year: Int,
    val Type: String,
    val Poster: String)
