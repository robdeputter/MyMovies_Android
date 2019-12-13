[app](../../index.md) / [com.example.mymovies.database](../index.md) / [WatchListDAO](./index.md)

# WatchListDAO

`interface WatchListDAO`

FavoritesDAO is an interface that provides all the methods that are necessary to manipulate the movies / series you want to watch
in the database

[Dao](#) Data Access Objects are the main classes where you define your database interactions. $
They can include a variety of query methods.

### Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | `abstract fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clear all the watchlistentities from the database |
| [delete](delete.md) | `abstract fun delete(movieSerie: `[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Delete a detailed object of a movie or serie to the database. This method is used when you remove a movie or serie from your watchlist |
| [get](get.md) | `abstract fun get(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`?`<br>Get a movie or serie by it's imdbId (unique) This method is used when you want to check if a movie or serie is already in your watchlist |
| [getAllWatchListentities](get-all-watch-listentities.md) | `abstract fun getAllWatchListentities(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`>>`<br>Get all the watchlistentities This method is used to get an overview of all your watchlistentities |
| [insert](insert.md) | `abstract fun insert(movieSerie: `[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Add a detailed object of a movie or serie to the database. This method is used when you add a movie or serie to your watchlist |
| [update](update.md) | `abstract fun update(movieSerie: `[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Update a detailed object of a movie or serie to the database. |
