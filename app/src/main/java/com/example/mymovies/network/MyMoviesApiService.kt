package com.example.mymovies.network

import com.example.mymovies.models.MovieSerie
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.MovieSerieResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://movie-database-imdb-alternative.p.rapidapi.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface MyMoviesApiService {

    @Headers("x-rapidapi-key: a5f6b222camsh8d8cf36d4842c16p1e1b3cjsnba17b5622d41")
    @GET("/")
    fun getMovieSeriesForName(@Query("s") nameOfMovieSerie : String) : Deferred<MovieSerieResponse>

    @Headers("x-rapidapi-key: a5f6b222camsh8d8cf36d4842c16p1e1b3cjsnba17b5622d41")
    @GET("/")
    fun getMovieSerieDetail(@Query("i") imdbID : String) : Deferred<NetworkMovieSerieDetail>

}

object MyMoviesApi {
    val retrofitService: MyMoviesApiService by lazy { retrofit.create(MyMoviesApiService::class.java) }
}