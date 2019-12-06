[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [FavoritsRepository](./index.md)

# FavoritsRepository

`class FavoritsRepository`

Responsible for manipulating and getting favorites

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FavoritsRepository(_database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md)`)`<br>Responsible for manipulating and getting favorites |

### Properties

| Name | Summary |
|---|---|
| [favorits](favorits.md) | `val favorits: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`>>`<br>Get all the favorites that are currently in the database |

### Functions

| Name | Summary |
|---|---|
| [addFavorit](add-favorit.md) | `suspend fun addFavorit(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, rating: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Add a favorite with its rating to the database |
| [getFavorit](get-favorit.md) | `suspend fun getFavorit(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`?`<br>Get a possible favorite by its imdbId |
| [removeFavorit](remove-favorit.md) | `suspend fun removeFavorit(movieSerieDetail: `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Remove a favorite from the database |
