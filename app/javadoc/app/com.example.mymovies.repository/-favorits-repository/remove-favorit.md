[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [FavoritsRepository](index.md) / [removeFavorit](./remove-favorit.md)

# removeFavorit

`suspend fun removeFavorit(movieSerieDetail: `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Remove a favorite from the database

[withContext](#) =&gt; Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
[Dispatchers.IO](#) =&gt; The [CoroutineDispatcher](#) that is designed for offloading blocking IO tasks to a shared pool of threads.

Why suspend? =&gt; you're using [withContext](#)

