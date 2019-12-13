[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [WatchListRepository](./index.md)

# WatchListRepository

`class WatchListRepository`

Responsible for manipulating and getting favorites

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WatchListRepository(_database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md)`)`<br>Responsible for manipulating and getting favorites |

### Properties

| Name | Summary |
|---|---|
| [watchListentities](watch-listentities.md) | `val watchListentities: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`>>`<br>Get all the watchlistEntities that are currently in the database |

### Functions

| Name | Summary |
|---|---|
| [addToWatchList](add-to-watch-list.md) | `suspend fun addToWatchList(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Add a movie / serie to the watchlist |
| [getWatchListentity](get-watch-listentity.md) | `suspend fun getWatchListentity(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`?`<br>Get a possible watchListentity by its imdbId |
| [removeWatchListEntity](remove-watch-list-entity.md) | `suspend fun removeWatchListEntity(movieSerieDetail: `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Remove a watchlistentity from the database if it's a favorite, just change the field to false |
