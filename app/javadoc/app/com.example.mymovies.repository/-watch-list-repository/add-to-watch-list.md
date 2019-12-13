[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [WatchListRepository](index.md) / [addToWatchList](./add-to-watch-list.md)

# addToWatchList

`suspend fun addToWatchList(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Add a movie / serie to the watchlist

[withContext](#) =&gt; Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
[Dispatchers.IO](#) =&gt; The [CoroutineDispatcher](#) that is designed for offloading blocking IO tasks to a shared pool of threads.

Why suspend? =&gt; you're using [withContext](#)

