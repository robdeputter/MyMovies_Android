[app](../../index.md) / [com.example.mymovies.screens.watchlist](../index.md) / [WatchlistViewModel](./index.md)

# WatchlistViewModel

`class WatchlistViewModel : ViewModel`

[ViewModel](#)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WatchlistViewModel(database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md)`)`<br>[ViewModel](#) |

### Properties

| Name | Summary |
|---|---|
| [database](database.md) | `val database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md) |
| [navigateToSelectedMovieSerie](navigate-to-selected-movie-serie.md) | `val navigateToSelectedMovieSerie: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>[LiveData](#) is a data holder class that can be observed within a given lifecycle. Keeps track if there's a movie or serie that has been clicked |
| [watchlistEntities](watchlist-entities.md) | `val watchlistEntities: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`>>`<br>[FavoritsRepository](../../com.example.mymovies.repository/-favorits-repository/index.md) |

### Functions

| Name | Summary |
|---|---|
| [displayMovieSerieDetails](display-movie-serie-details.md) | `fun displayMovieSerieDetails(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the imdbId of the clicked movie or serie |
| [displayMovieSerieDetailsComplete](display-movie-serie-details-complete.md) | `fun displayMovieSerieDetailsComplete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method is called after the navigation to the detailed page |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>[Job](#) needs to be cancelled |
| [removeFromFavorites](remove-from-favorites.md) | `fun removeFromFavorites(movieSerieDetail: `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Calls the removeMethod from the [FavoritsRepository](../../com.example.mymovies.repository/-favorits-repository/index.md) Is performed asynchronously on the main-thread =&gt; Database operation |
