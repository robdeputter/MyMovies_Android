[app](../../index.md) / [com.example.mymovies.database](../index.md) / [NewReleaseDAO](index.md) / [insertAll](./insert-all.md)

# insertAll

`abstract fun insertAll(vararg newReleases: `[`DatabaseNewRelease`](../-database-new-release/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Insert all the new releases

"onConflict = = OnConflictStrategy.REPLACE) = if a value in the database has the same imdbId as the one that you want to add,
then you replace it with the new value

[vararg](#) =&gt; When we call a vararg-function, we can pass arguments one-by-one
==&gt; vararg will insert the new releases, one by one

