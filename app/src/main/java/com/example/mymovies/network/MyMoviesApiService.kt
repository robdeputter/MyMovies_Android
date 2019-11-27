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
import retrofit2.http.*

private const val BASE_URL = "https://movie-database-imdb-alternative.p.rapidapi.com"
private const val BASE_URL2 = "https://unogs-unogs-v1.p.rapidapi.com/aaapi.cgi/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

private val retrofit2 = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL2)
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


// other api call for new releases

interface NewReleasesApiService{
    @Headers("x-rapidapi-key: a5f6b222camsh8d8cf36d4842c16p1e1b3cjsnba17b5622d41")
    @GET("?q=get:new7:BE&p=1")
    fun getNewReleases() : Deferred<NewReleaseResponse>
}

object NewReleasesApi {
    val retrofitService: NewReleasesApiService by lazy { retrofit2.create(NewReleasesApiService::class.java) }
}