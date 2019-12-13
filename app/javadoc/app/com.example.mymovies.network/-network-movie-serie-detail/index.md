[app](../../index.md) / [com.example.mymovies.network](../index.md) / [NetworkMovieSerieDetail](./index.md)

# NetworkMovieSerieDetail

`@JsonClass(true) data class NetworkMovieSerieDetail`

The network version of [MovieSerieDetail](../../com.example.mymovies.models/-movie-serie-detail/index.md)

[JsonClass](#) -&gt; Parses json data into a kotlin object
(it will generate a JsonAdapter to handle serializing/deserializing to and from JSON of the specified type.)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkMovieSerieDetail(imdbID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Poster: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Released: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Runtime: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, Genre: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Actors: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, imdbRating: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, imdbVotes: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Plot: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?)`<br>The network version of [MovieSerieDetail](../../com.example.mymovies.models/-movie-serie-detail/index.md) |

### Properties

| Name | Summary |
|---|---|
| [Actors](-actors.md) | `val Actors: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [Genre](-genre.md) | `val Genre: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [Plot](-plot.md) | `val Plot: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [Poster](-poster.md) | `val Poster: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [Released](-released.md) | `val Released: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [Runtime](-runtime.md) | `val Runtime: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [Title](-title.md) | `val Title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [Type](-type.md) | `val Type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [Year](-year.md) | `val Year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [favoriteRating](favorite-rating.md) | `var favoriteRating: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [imdbID](imdb-i-d.md) | `val imdbID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imdbRating](imdb-rating.md) | `val imdbRating: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imdbVotes](imdb-votes.md) | `val imdbVotes: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [inWatchList](in-watch-list.md) | `var inWatchList: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [asDatabaseModel](../as-database-model.md) | `fun `[`NetworkMovieSerieDetail`](./index.md)`.asDatabaseModel(): `[`DatabaseMovieSerieDetail`](../../com.example.mymovies.database/-database-movie-serie-detail/index.md)<br>Converts a list of [NetworkMovieSerieDetail](./index.md) to a list of [DatabaseMovieSerieDetail](../../com.example.mymovies.database/-database-movie-serie-detail/index.md) |
| [asDomainModel](../as-domain-model.md) | `fun `[`NetworkMovieSerieDetail`](./index.md)`.asDomainModel(): `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)<br>Converts a list of [NetworkMovieSerieDetail](./index.md) to a list of [NetworkMovieSerie](../-network-movie-serie/index.md) |
