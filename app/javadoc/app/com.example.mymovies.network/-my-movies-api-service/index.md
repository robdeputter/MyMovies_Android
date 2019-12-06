[app](../../index.md) / [com.example.mymovies.network](../index.md) / [MyMoviesApiService](./index.md)

# MyMoviesApiService

`interface MyMoviesApiService`

Contains all the network calls to get [MovieSerieDetail](../../com.example.mymovies.models/-movie-serie-detail/index.md) and [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md) properties

### Functions

| Name | Summary |
|---|---|
| [getMovieSerieDetail](get-movie-serie-detail.md) | `abstract fun getMovieSerieDetail(imdbID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Deferred<`[`NetworkMovieSerieDetail`](../-network-movie-serie-detail/index.md)`>`<br>[GET](#) request to get a movie or serie for a specific imdbId |
| [getMovieSeriesForName](get-movie-series-for-name.md) | `abstract fun getMovieSeriesForName(nameOfMovieSerie: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): Deferred<`[`MovieSerieResponse`](../../com.example.mymovies.models/-movie-serie-response/index.md)`>`<br>[GET](#) request to get all the movies and series for a specific name, year and type |
