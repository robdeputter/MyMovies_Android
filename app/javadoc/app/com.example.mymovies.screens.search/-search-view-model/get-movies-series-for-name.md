[app](../../index.md) / [com.example.mymovies.screens.search](../index.md) / [SearchViewModel](index.md) / [getMoviesSeriesForName](./get-movies-series-for-name.md)

# getMoviesSeriesForName

`fun getMoviesSeriesForName(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Calls getMovieSerieDetail method from [MovieSerieRepository](../../com.example.mymovies.repository/-movie-serie-repository/index.md)
Sets the Api status
Loads the [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md) object

Is performed asynchronously on the main-thread =&gt; Network operation
Otherwise =&gt; can cause a bad user experience (lag)

