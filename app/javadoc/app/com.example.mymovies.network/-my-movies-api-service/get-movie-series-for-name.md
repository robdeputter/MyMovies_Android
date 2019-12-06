[app](../../index.md) / [com.example.mymovies.network](../index.md) / [MyMoviesApiService](index.md) / [getMovieSeriesForName](./get-movie-series-for-name.md)

# getMovieSeriesForName

`@Headers(["x-rapidapi-key: a5f6b222camsh8d8cf36d4842c16p1e1b3cjsnba17b5622d41"]) @GET("/") abstract fun getMovieSeriesForName(@Query("s") nameOfMovieSerie: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("y") year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, @Query("type") type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): Deferred<`[`MovieSerieResponse`](../../com.example.mymovies.models/-movie-serie-response/index.md)`>`

[GET](#) request to get all the movies and series for a specific name, year and type

**Return**
Deferred object that contains a [MovieSerieResponse](#) = Awaits for completion of this value without blocking a thread and resumes when deferred computation is complete,
returning the resulting value or throwing the corresponding exception if the deferred was cancelled.

