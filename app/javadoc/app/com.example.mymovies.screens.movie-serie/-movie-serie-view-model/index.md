[app](../../index.md) / [com.example.mymovies.screens.movieSerie](../index.md) / [MovieSerieViewModel](./index.md)

# MovieSerieViewModel

`class MovieSerieViewModel : ViewModel`

[ViewModel](#)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MovieSerieViewModel(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)`<br>[ViewModel](#) |

### Properties

| Name | Summary |
|---|---|
| [application](application.md) | `val application: `[`Application`](https://developer.android.com/reference/android/app/Application.html) |
| [imdbId](imdb-id.md) | `val imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [inFavorits](in-favorits.md) | `val inFavorits: LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [inWatchlist](in-watchlist.md) | `val inWatchlist: LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [movieSerie](movie-serie.md) | `val movieSerie: LiveData<`[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`>` |
| [showSnackbarEventFavorites](show-snackbar-event-favorites.md) | `val showSnackbarEventFavorites: LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [showSnackbarEventWatchlist](show-snackbar-event-watchlist.md) | `val showSnackbarEventWatchlist: LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [status](status.md) | `val status: LiveData<`[`MyMoviesApiStatus`](../../com.example.mymovies.screens.search/-my-movies-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [addToFavorits](add-to-favorits.md) | `fun addToFavorits(rating: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Calls the addFavoriteMethod from the [FavoritsRepository](../../com.example.mymovies.repository/-favorits-repository/index.md) Is performed asynchronously on the main-thread =&gt; Database operation |
| [addToWatchlist](add-to-watchlist.md) | `fun addToWatchlist(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Calls the addFavoriteMethod from the [WatchListRepository](../../com.example.mymovies.repository/-watch-list-repository/index.md) Is performed asynchronously on the main-thread =&gt; Database operation |
| [doneShowingSnackbarFavorites](done-showing-snackbar-favorites.md) | `fun doneShowingSnackbarFavorites(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets showSnackbarFavorites to false |
| [doneShowingSnackbarWatchlist](done-showing-snackbar-watchlist.md) | `fun doneShowingSnackbarWatchlist(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets showSnackbar to false |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Cancels [Job](#) |
| [removeFromFavorits](remove-from-favorits.md) | `fun removeFromFavorits(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Calls the removeMethod from the [FavoritsRepository](../../com.example.mymovies.repository/-favorits-repository/index.md) Is performed asynchronously on the main-thread =&gt; Database operation |
| [removeFromWatchlist](remove-from-watchlist.md) | `fun removeFromWatchlist(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Calls the removeMethod from the [WatchListRepository](../../com.example.mymovies.repository/-watch-list-repository/index.md) Is performed asynchronously on the main-thread =&gt; Database operation |
