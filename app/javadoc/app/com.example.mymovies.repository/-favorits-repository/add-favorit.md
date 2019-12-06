[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [FavoritsRepository](index.md) / [addFavorit](./add-favorit.md)

# addFavorit

`suspend fun addFavorit(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, rating: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Add a favorite with its rating to the database

[withContext](#) =&gt; Calls the specified suspending block with a given coroutine context, suspends until it completes, and returns the result.
[Dispatchers.IO](#) =&gt; The [CoroutineDispatcher](#) that is designed for offloading blocking IO tasks to a shared pool of threads.

Why suspend? =&gt; you're using [withContext](#)

