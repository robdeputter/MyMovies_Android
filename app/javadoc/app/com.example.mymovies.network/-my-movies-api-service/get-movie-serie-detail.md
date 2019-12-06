[app](../../index.md) / [com.example.mymovies.network](../index.md) / [MyMoviesApiService](index.md) / [getMovieSerieDetail](./get-movie-serie-detail.md)

# getMovieSerieDetail

`@Headers(["x-rapidapi-key: a5f6b222camsh8d8cf36d4842c16p1e1b3cjsnba17b5622d41"]) @GET("/") abstract fun getMovieSerieDetail(@Query("i") imdbID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Deferred<`[`NetworkMovieSerieDetail`](../-network-movie-serie-detail/index.md)`>`

[GET](#) request to get a movie or serie for a specific imdbId

**Return**

Deferred object that contains a [NetworkMovieSerieDetail](../-network-movie-serie-detail/index.md)



[Deferred](#) = Awaits for completion of this value without blocking a thread and resumes when deferred computation is complete,
returning the resulting value or throwing the corresponding exception if the deferred was cancelled.

