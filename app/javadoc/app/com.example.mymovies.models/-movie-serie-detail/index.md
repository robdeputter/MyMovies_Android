[app](../../index.md) / [com.example.mymovies.models](../index.md) / [MovieSerieDetail](./index.md)

# MovieSerieDetail

`data class MovieSerieDetail`

MovieSerieDetail is detailed list that describes a movie or serie

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MovieSerieDetail(imdbID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, poster: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, released: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, runTime: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, genre: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, actors: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, imdbRating: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, imdbVotes: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, favoriteRating: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?, plot: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?)`<br>MovieSerieDetail is detailed list that describes a movie or serie |

### Properties

| Name | Summary |
|---|---|
| [actors](actors.md) | `val actors: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [favoriteRating](favorite-rating.md) | `val favoriteRating: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?` |
| [genre](genre.md) | `val genre: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imdbID](imdb-i-d.md) | `val imdbID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imdbRating](imdb-rating.md) | `val imdbRating: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imdbVotes](imdb-votes.md) | `val imdbVotes: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [plot](plot.md) | `val plot: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [poster](poster.md) | `val poster: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [released](released.md) | `val released: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [runTime](run-time.md) | `val runTime: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [title](title.md) | `val title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | `val type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [year](year.md) | `val year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [asDatabaseModel](../as-database-model.md) | `fun `[`MovieSerieDetail`](./index.md)`.asDatabaseModel(): `[`DatabaseMovieSerieDetail`](../../com.example.mymovies.database/-database-movie-serie-detail/index.md)<br>Converts a MovieSerieDetail to a databaseproperty This method is called when you want to add a favorite to the database |
