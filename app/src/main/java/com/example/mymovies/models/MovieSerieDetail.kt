package com.example.mymovies.models

import com.example.mymovies.database.DatabaseMovieSerieDetail

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
    val plot: String?
) {
    var inWatchList: Boolean = false
    get() = field
    set(value) {
        field = value
    }
    var favoriteRating: Float = Float.NaN
        get() = field
        set(value) {
            field = value
        }
}

/**
 * Converts a MovieSerieDetail to a databaseproperty
 * This method is called when you want to add a favorite to the database
 */
fun MovieSerieDetail.asDatabaseModel(): DatabaseMovieSerieDetail {
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
        plot = plot,
        inWatchList = inWatchList
    )
}