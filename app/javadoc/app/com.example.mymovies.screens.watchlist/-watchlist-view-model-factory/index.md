[app](../../index.md) / [com.example.mymovies.screens.watchlist](../index.md) / [WatchlistViewModelFactory](./index.md)

# WatchlistViewModelFactory

`class WatchlistViewModelFactory : Factory`

Responsible for creating a [FavoritesViewModel](#) instance

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WatchlistViewModelFactory(application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`, database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md)`)`<br>Responsible for creating a [FavoritesViewModel](#) instance |

### Properties

| Name | Summary |
|---|---|
| [application](application.md) | `val application: `[`Application`](https://developer.android.com/reference/android/app/Application.html) |
| [database](database.md) | `val database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md) |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T : ViewModel?> create(modelClass: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<`[`T`](create.md#T)`>): `[`T`](create.md#T) |
