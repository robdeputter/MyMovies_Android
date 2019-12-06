[app](../../index.md) / [com.example.mymovies.screens.newRelease](../index.md) / [NewReleaseViewModel](./index.md)

# NewReleaseViewModel

`class NewReleaseViewModel : ViewModel`

[ViewModel](#)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NewReleaseViewModel(_database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md)`)`<br>[ViewModel](#) |

### Properties

| Name | Summary |
|---|---|
| [navigateToSelectedMovieSerie](navigate-to-selected-movie-serie.md) | `val navigateToSelectedMovieSerie: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [newReleases](new-releases.md) | `val newReleases: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NewRelease`](../../com.example.mymovies.models/-new-release/index.md)`>>`<br>Loads the new Releases from the database |
| [status](status.md) | `val status: LiveData<`[`MyMoviesApiStatus`](../../com.example.mymovies.screens.search/-my-movies-api-status/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [displayMovieSerieDetails](display-movie-serie-details.md) | `fun displayMovieSerieDetails(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the imdId value of the clicked item |
| [displayMovieSerieDetailsComplete](display-movie-serie-details-complete.md) | `fun displayMovieSerieDetailsComplete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Reset to null if the navigation is complete |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Cancels [Job](#) |
