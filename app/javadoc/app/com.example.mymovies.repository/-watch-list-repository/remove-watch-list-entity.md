[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [WatchListRepository](index.md) / [removeWatchListEntity](./remove-watch-list-entity.md)

# removeWatchListEntity

`suspend fun removeWatchListEntity(movieSerieDetail: `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Remove a watchlistentity from the database if it's a favorite, just change the field to false

[withContext](#) =&gt; Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
[Dispatchers.IO](#) =&gt; The [CoroutineDispatcher](#) that is designed for offloading blocking IO tasks to a shared pool of threads.

Why suspend? =&gt; you're using [withContext](#)

