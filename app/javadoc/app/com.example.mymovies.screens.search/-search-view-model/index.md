[app](../../index.md) / [com.example.mymovies.screens.search](../index.md) / [SearchViewModel](./index.md)

# SearchViewModel

`class SearchViewModel : ViewModel`

[ViewModel](#)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SearchViewModel()`<br>[ViewModel](#) |

### Properties

| Name | Summary |
|---|---|
| [movieSerieList](movie-serie-list.md) | `val movieSerieList: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MovieSerie`](../../com.example.mymovies.models/-movie-serie/index.md)`>>` |
| [navigateToSelectedMovieSerie](navigate-to-selected-movie-serie.md) | `val navigateToSelectedMovieSerie: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [status](status.md) | `val status: LiveData<`[`MyMoviesApiStatus`](../-my-movies-api-status/index.md)`>` |
| [typeFilter](type-filter.md) | `val typeFilter: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [yearFilter](year-filter.md) | `val yearFilter: LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| [displayMovieSerieDetails](display-movie-serie-details.md) | `fun displayMovieSerieDetails(imdbId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets imdbId of clicked movie or serie |
| [displayMovieSerieDetailsComplete](display-movie-serie-details-complete.md) | `fun displayMovieSerieDetailsComplete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Resets value after navigation |
| [getMoviesSeriesForName](get-movies-series-for-name.md) | `fun getMoviesSeriesForName(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Calls getMovieSerieDetail method from [MovieSerieRepository](../../com.example.mymovies.repository/-movie-serie-repository/index.md) Sets the Api status Loads the [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md) object |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Cancels [Job](#) |
