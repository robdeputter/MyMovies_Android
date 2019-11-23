package com.example.mymovies.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mymovies.models.MovieSerieDetail

@Entity
data class DatabaseMovieSerieDetail constructor(
    @PrimaryKey
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

fun List<DatabaseMovieSerieDetail>.asDomainModel(): List<MovieSerieDetail> {
    return map {
        MovieSerieDetail(
            imdbID = it.imdbID,
            title = it.title,
            year = it.year,
            type = it.type,
            poster = it.poster,
            released = it.released,
            runTime = it.runTime,
            genre = it.genre,
            actors = it.actors,
            imdbRating = it.imdbRating,
            imdbVotes = it.imdbVotes
        )
    }
}

fun DatabaseMovieSerieDetail.asDomainModel() : MovieSerieDetail{
    return MovieSerieDetail(
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
        imdbVotes = imdbVotes
    )
}