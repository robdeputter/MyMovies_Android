[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [MovieSerieRepository](index.md) / [getMovieSeriesByFilter](./get-movie-series-by-filter.md)

# getMovieSeriesByFilter

`suspend fun getMovieSeriesByFilter(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MovieSerie`](../../com.example.mymovies.models/-movie-serie/index.md)`>?`

Get a list of [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md) through a network call

**Return**

possible list of [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md)



Why suspend? = you're calling an await() function on the [Deferred](#) object

