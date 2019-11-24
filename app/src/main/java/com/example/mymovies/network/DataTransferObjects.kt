package com.example.mymovies.network

import androidx.room.Database
import com.example.mymovies.database.DatabaseMovieSerieDetail
import com.example.mymovies.database.DatabaseNewRelease
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.NewRelease
import com.squareup.moshi.JsonClass
import java.lang.Exception
import java.nio.channels.NetworkChannel
import java.security.spec.ECField


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
@JsonClass(generateAdapter = true)
data class NetworkNewReleases(val newReleases: List<NetworkNewRelease>)

@JsonClass(generateAdapter = true)
data class NetworkNewRelease(
    val imdbID: String?,
    val title: String,
    val type: String,
    val image: String?,
    val released: String?)

fun NetworkNewReleases.asDomainModel(): List<NewRelease?> {
    return newReleases.map {
        try {
            NewRelease(
                imdbID = it.imdbID!!,
                title = it.title,
                image = it.image,
                released = it.released,
                type = it.type)
        }catch (e : Exception){
            null
        }
    }
}

fun NetworkNewReleases.asDatabaseModel(): Array<DatabaseNewRelease?>{
    return newReleases.map {
        try {
            DatabaseNewRelease(
                imdbID = it.imdbID!!,
                title = it.title,
                image = it.image,
                released = it.released,
                type = it.type
            )
        }catch (e : Exception){
            null
        }
    }.toTypedArray()
}
