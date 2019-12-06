[app](../../index.md) / [com.example.mymovies.database](../index.md) / [FavoritesDAO](./index.md)

# FavoritesDAO

`interface FavoritesDAO`

FavoritesDAO is an interface that provides all the methods that are necessary to manipulate the favorites
in the database

[Dao](#) Data Access Objects are the main classes where you define your database interactions. $
They can include a variety of query methods.

### Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | `abstract fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clear all the favorites from the database |
| [delete](delete.md) | `abstract fun delete(movieSerie: `[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Delete a detailed object of a movie or serie to the database. This method is used when you remove a movie or serie from your favorites |
| [get](get.md) | `abstract fun get(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`?`<br>Get a movie or serie by it's imdbId (unique) This method is used when you want to check if a movie or serie is already in your favorites |
| [getAllFavorits](get-all-favorits.md) | `abstract fun getAllFavorits(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`>>`<br>Get all the favorites This method is used to get an overview of all your favorites |
| [insert](insert.md) | `abstract fun insert(movieSerie: `[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Add a detailed object of a movie or serie to the database. This method is used when you add a movie or serie to your favorites |
| [update](update.md) | `abstract fun update(movieSerie: `[`DatabaseMovieSerieDetail`](../-database-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Update a detailed object of a movie or serie to the database. |
