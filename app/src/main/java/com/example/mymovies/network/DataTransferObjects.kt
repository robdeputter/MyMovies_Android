package com.example.mymovies.network

import com.example.mymovies.database.DatabaseMovieSerieDetail
import com.example.mymovies.models.MovieSerieDetail
import com.squareup.moshi.JsonClass
import java.nio.channels.NetworkChannel



@JsonClass(generateAdapter = true)
data class NetworkMovieSerieDetail(
    val imdbID: String,
    val Title: String,
    val Year: String,
    val Type: String,
    val Poster: String,
    val Released: String,
    val RunTime: String?,
    val Genre: String,
    val Actors: String,
    val imdbRating: String,
    val imdbVotes: String)

fun NetworkMovieSerieDetail.asDomainModel(): MovieSerieDetail {
    return MovieSerieDetail(
            imdbID = imdbID,
            title = Title,
            year = Year,
            type = Type,
            poster = Poster,
            released = Released,
            runTime = RunTime,
            genre = Genre,
            actors = Actors,
            imdbRating = imdbRating,
            imdbVotes = imdbVotes)
    }


fun NetworkMovieSerieDetail.asDatabaseModel(): DatabaseMovieSerieDetail{
    return DatabaseMovieSerieDetail(
            imdbID = imdbID,
            title = Title,
            year = Year,
            type = Type,
            poster = Poster,
            released = Released,
            runTime = RunTime,
            genre = Genre,
            actors = Actors,
            imdbRating = imdbRating,
            imdbVotes = imdbVotes
        )
}
