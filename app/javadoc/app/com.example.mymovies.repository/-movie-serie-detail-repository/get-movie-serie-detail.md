[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [MovieSerieDetailRepository](index.md) / [getMovieSerieDetail](./get-movie-serie-detail.md)

# getMovieSerieDetail

`suspend fun getMovieSerieDetail(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`?`

Get a MovieSerieDetail through a network call

**Return**

possible [MovieSerieDetail](../../com.example.mymovies.models/-movie-serie-detail/index.md) object (if imdbId is unknown in the back-end =&gt; null)



Why suspend? = you're calling an await() function on the [Deferred](#) object

