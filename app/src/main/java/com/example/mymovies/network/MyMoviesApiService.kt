package com.example.mymovies.network

import com.example.mymovies.models.MovieSerie
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.MovieSerieResponse
import com.example.mymovies.models.NewReleaseResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * imDB URL to get detailed information of movies and series
 */
private const val BASE_URL = "https://movie-database-imdb-alternative.p.rapidapi.com"

/**
 * uNoGS URL to get detailed information of all the new releases from Netflix
 */
private const val BASE_URL2 = "https://unogs-unogs-v1.p.rapidapi.com/aaapi.cgi/"

/**
 * [Moshi] is responsible for the parsing of JSON data to kotlin objects
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 *
 * [Retrofit] makes it possible to send network calls to a specific URL (back-end)
 * Retrofit valuable to send network calls to the imDB back-end
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

/**
 * [Retrofit] makes it possible to send network calls to a specific URL (back-end)
 * Retrofit valuable to send network calls to the uNoGS back-end
 */
private val retrofit2 = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL2)
    .build()

/**
 * Contains all the network calls to get [MovieSerieDetail] and [MovieSerie] properties
 */
interface MyMoviesApiService {

    /**
     * [GET] request to get all the movies and series for a specific name, year and type
     *
     * @return Deferred object that contains a [MovieSerieResponse]
     * [Deferred] = Awaits for completion of this value without blocking a thread and resumes when deferred computation is complete,
     * returning the resulting value or throwing the corresponding exception if the deferred was cancelled.
     */
    @Headers("x-rapidapi-key: a5f6b222camsh8d8cf36d4842c16p1e1b3cjsnba17b5622d41")
    @GET("/")
    fun getMovieSeriesForName(
        @Query("s") nameOfMovieSerie: String,
        @Query("y") year: String?,
        @Query("type") type: String?
    ): Deferred<MovieSerieResponse>
    /**
     * [GET] request to get a movie or serie for a specific imdbId
     *
     * @return Deferred object that contains a [NetworkMovieSerieDetail]
     *
     * [Deferred] = Awaits for completion of this value without blocking a thread and resumes when deferred computation is complete,
     * returning the resulting value or throwing the corresponding exception if the deferred was cancelled.
     */

    @Headers("x-rapidapi-key: a5f6b222camsh8d8cf36d4842c16p1e1b3cjsnba17b5622d41")
    @GET("/")
    fun getMovieSerieDetail(@Query("i") imdbID: String): Deferred<NetworkMovieSerieDetail>
}

/**
 * [object] => singleton
 * Provides a lazy initialization of [MyMoviesApiService]
 * lazy => you create it when it's needed
 */
object MyMoviesApi {
    val retrofitService: MyMoviesApiService by lazy { retrofit.create(MyMoviesApiService::class.java) }
}

interface NewReleasesApiService {

    /**
     * [GET] request to get all the new releases from Netflix
     *
     * @return Deferred object that contains a [NewReleaseResponse]
     *
     * [Deferred] = Awaits for completion of this value without blocking a thread and resumes when deferred computation is complete,
     * returning the resulting value or throwing the corresponding exception if the deferred was cancelled.
     */
    @Headers("x-rapidapi-key: a5f6b222camsh8d8cf36d4842c16p1e1b3cjsnba17b5622d41")
    @GET("?q=get:new7:BE&p=1")
    fun getNewReleases(): Deferred<NewReleaseResponse>
}

/**
 * [object] => singleton
 * Provides a lazy initialization of [NewReleasesApiService]
 * lazy => you create it when it's needed
 */
object NewReleasesApi {
    val retrofitService: NewReleasesApiService by lazy { retrofit2.create(NewReleasesApiService::class.java) }
}