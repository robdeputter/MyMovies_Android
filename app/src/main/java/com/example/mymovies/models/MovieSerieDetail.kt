package com.example.mymovies.models


import android.os.Parcel
import android.os.Parcelable
import com.example.mymovies.database.DatabaseMovieSerieDetail

import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * MovieSerieDetail is detailed list that describes a movie or serie
 */
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
    val imdbVotes: String,
    val favoriteRating : Float?,
    val plot : String?)

/**
 * Converts a MovieSerieDetail to a databaseproperty
 * This method is called when you want to add a favorite to the database
 */
fun MovieSerieDetail.asDatabaseModel() : DatabaseMovieSerieDetail{
    return DatabaseMovieSerieDetail(
        imdbID = imdbID,
        title = title,
        year = year,
        type = type,
        poster = poster,
        released = released,
        runTime = runTime,
        genre = genre,
        actors = actors,
        imdbRating = imdbRating,
        imdbVotes = imdbVotes,
        favoriteRating = favoriteRating,
        plot = plot
    )
}