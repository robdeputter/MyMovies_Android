package com.example.mymovies.network

import androidx.room.Database
import com.example.mymovies.database.DatabaseMovieSerieDetail
import com.example.mymovies.database.DatabaseNewRelease
import com.example.mymovies.models.MovieSerie
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.NewRelease
import com.squareup.moshi.JsonClass
import retrofit2.http.GET
import java.lang.Exception
import java.nio.channels.NetworkChannel
import java.security.spec.ECField

/*

data class MovieSerie(
    val imdbID: String,
    val Title: String,
    val Year: String,
    val Type: String,
    val Poster: String)*/

//Short information about a movie or serie
@JsonClass(generateAdapter = true)
data class NetworkMovieSerie(
    val imdbID: String,
    val Title: String,
    val Year: String,
    val Type: String,
    val Poster: String
)

fun List<NetworkMovieSerie>.asDomainModel_MovieSerie() : List<MovieSerie>{
    return this.map {
        MovieSerie(
            imdbID = it.imdbID,
            type = it.Type,
            year = it.Year,
            title = it.Title,
            poster = it.Poster
        )
    }
}


// Details of a Movie of Serie
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
    val imdbVotes: String,
    val Plot : String?
    ){
    var favoriteRating : Float = Float.NaN
        get() = field
        set(value){field = value}
}

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
            imdbVotes = imdbVotes,
            favoriteRating = favoriteRating,
            plot = Plot
            )
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
            imdbVotes = imdbVotes,
            favoriteRating = favoriteRating,
            plot = Plot

        )
}

// New releases on netflix
@JsonClass(generateAdapter = true)
data class NetworkNewRelease(
    val imdbid: String?,
    val title: String,
    val type: String,
    val image: String?,
    val released: String?)

fun List<NetworkNewRelease>.asDomainModel(): List<NewRelease?> {
    return this.map {
        try {
            NewRelease(
                imdbID = it.imdbid!!,
                title = it.title,
                image = it.image,
                released = it.released,
                type = it.type)
        }catch (e : Exception){
            null
        }
    }
}

fun List<NetworkNewRelease>.asDatabaseModel(): Array<DatabaseNewRelease?>{
    return this.map {
        try {
            DatabaseNewRelease(
                imdbID = it.imdbid!!,
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
