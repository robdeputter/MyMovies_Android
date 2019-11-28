package com.example.mymovies.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


data class MovieSerie(
    val imdbID: String,
    val title: String,
    val year: String,
    val type: String,
    val poster: String)
