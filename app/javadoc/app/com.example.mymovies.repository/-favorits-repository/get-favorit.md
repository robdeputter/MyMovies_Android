[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [FavoritsRepository](index.md) / [getFavorit](./get-favorit.md)

# getFavorit

`suspend fun getFavorit(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`?`

Get a possible favorite by its imdbId

**Return**

a possible favorite ( = [MovieSerieDetail](../../com.example.mymovies.models/-movie-serie-detail/index.md))



[withContext](#) =&gt; Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
[Dispatchers.IO](#) =&gt; The [CoroutineDispatcher](#) that is designed for offloading blocking IO tasks to a shared pool of threads.



Why suspend? =&gt; you're using [withContext](#)

