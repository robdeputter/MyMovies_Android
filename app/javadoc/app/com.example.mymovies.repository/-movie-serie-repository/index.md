[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [MovieSerieRepository](./index.md)

# MovieSerieRepository

`class MovieSerieRepository`

Responsible for getting [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md) objects

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MovieSerieRepository()`<br>Responsible for getting [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md) objects |

### Functions

| Name | Summary |
|---|---|
| [getMovieSeriesByFilter](get-movie-series-by-filter.md) | `suspend fun getMovieSeriesByFilter(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MovieSerie`](../../com.example.mymovies.models/-movie-serie/index.md)`>?`<br>Get a list of [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md) through a network call |
