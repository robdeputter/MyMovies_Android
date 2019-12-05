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


/**
 * The network version of [MovieSerie]
 * Jsondata that's received from the imdb-network is parsed in this data class
 *
 *[JsonClass] -> Parses json data into a kotlin object (it will generate a JsonAdapter to handle serializing/deserializing to and from JSON of the specified type.)
 *
 */
@JsonClass(generateAdapter = true)
data class NetworkMovieSerie(
    val imdbID: String,
    val Title: String,
    val Year: String,
    val Type: String,
    val Poster: String
)

/**
 * Converts a list of [NetworkMovieSerie] to a list of [MovieSerie]
 */
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

/**
 * The network version of [MovieSerieDetail]
 *
 *[JsonClass] -> Parses json data into a kotlin object
 * (it will generate a JsonAdapter to handle serializing/deserializing to and from JSON of the specified type.)
 */
@JsonClass(generateAdapter = true)
data class NetworkMovieSerieDetail(
    val imdbID: String,
    val Title: String,
    val Year: String,
    val Type: String,
    val Poster: String,
    val Released: String,
    val Runtime: String?,
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

/**
 * Converts a list of [NetworkMovieSerieDetail] to a list of [NetworkMovieSerie]
 */
fun NetworkMovieSerieDetail.asDomainModel(): MovieSerieDetail {
    return MovieSerieDetail(
            imdbID = imdbID,
            title = Title,
            year = Year,
            type = Type,
            poster = Poster,
            released = Released,
            runTime = Runtime,
            genre = Genre,
            actors = Actors,
            imdbRating = imdbRating,
            imdbVotes = imdbVotes,
            favoriteRating = favoriteRating,
            plot = Plot
            )
    }

/**
 * Converts a list of [NetworkMovieSerieDetail] to a list of [DatabaseMovieSerieDetail]
 */
fun NetworkMovieSerieDetail.asDatabaseModel(): DatabaseMovieSerieDetail{
    return DatabaseMovieSerieDetail(
            imdbID = imdbID,
            title = Title,
            year = Year,
            type = Type,
            poster = Poster,
            released = Released,
            runTime = Runtime,
            genre = Genre,
            actors = Actors,
            imdbRating = imdbRating,
            imdbVotes = imdbVotes,
            favoriteRating = favoriteRating,
            plot = Plot

        )
}

/**
 * The network version of [NewRelease]
 *
 *[JsonClass] -> Parses json data into a kotlin object
 * (it will generate a JsonAdapter to handle serializing/deserializing to and from JSON of the specified type.)
 */
@JsonClass(generateAdapter = true)
data class NetworkNewRelease(
    val imdbid: String?,
    val title: String,
    val type: String,
    val image: String?,
    val released: String?)

/**
 * Converts a list of [NetworkNewRelease] to a list of [NewRelease]
 */
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

/**
 * Converts a List of [NetworkNewRelease] to a Array of [DatabaseNewRelease]
 */
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
