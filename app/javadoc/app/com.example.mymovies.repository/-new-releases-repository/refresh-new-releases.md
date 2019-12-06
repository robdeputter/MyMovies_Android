[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [NewReleasesRepository](index.md) / [refreshNewReleases](./refresh-new-releases.md)

# refreshNewReleases

`suspend fun refreshNewReleases(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Refresh the database objects by the objects from the network (back-end)

[withContext](#) =&gt; Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
[Dispatchers.IO](#) =&gt; The [CoroutineDispatcher](#) that is designed for offloading blocking IO tasks to a shared pool of threads.

Why suspend? =&gt; you're using [withContext](#)

