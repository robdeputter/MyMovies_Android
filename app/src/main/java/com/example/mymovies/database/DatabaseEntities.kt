package com.example.mymovies.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.NewRelease

/**
 * Databaseproperty for the details of a movie or serie
 */
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
    val imdbVotes: String,
    val favoriteRating: Float?,
    val plot: String?
)

/**
 * Converts a list of [DatabaseMovieSerieDetail] to a list of [MovieSerieDetail] (details of a movie or serie)
 */
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
            imdbVotes = it.imdbVotes,
            favoriteRating = it.favoriteRating,
            plot = it.plot
        )
    }
}

/**
 * Converts a [DatabaseMovieSerieDetail] to a [MovieSerieDetail]
 */
fun DatabaseMovieSerieDetail.asDomainModel(): MovieSerieDetail {
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
        imdbVotes = imdbVotes,
        favoriteRating = favoriteRating,
        plot = plot
    )
}

/**
 * Databaseproperty for a new release (on Netflix)
 */
@Entity
data class DatabaseNewRelease constructor(
    @PrimaryKey
    val imdbID: String,
    val title: String,
    val released: String?,
    val type: String,
    val image: String?
)

/**
 * Converts a list of [DatabaseNewRelease] to a list of [NewRelease]
 */
fun List<DatabaseNewRelease>.asDomainModel_NewRelease(): List<NewRelease> {
    return map {
        NewRelease(
            imdbID = it.imdbID,
            title = it.title,
            type = it.type,
            image = it.image,
            released = it.released
        )
    }
}