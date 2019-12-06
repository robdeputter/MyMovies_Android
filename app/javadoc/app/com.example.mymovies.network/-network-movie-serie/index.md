[app](../../index.md) / [com.example.mymovies.network](../index.md) / [NetworkMovieSerie](./index.md)

# NetworkMovieSerie

`@JsonClass(true) data class NetworkMovieSerie`

The network version of [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md)
Jsondata that's received from the imdb-network is parsed in this data class

[JsonClass](#) -&gt; Parses json data into a kotlin object (it will generate a JsonAdapter to handle serializing/deserializing to and from JSON of the specified type.)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkMovieSerie(imdbID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, Poster: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>The network version of [MovieSerie](../../com.example.mymovies.models/-movie-serie/index.md) Jsondata that's received from the imdb-network is parsed in this data class |

### Properties

| Name | Summary |
|---|---|
| [Poster](-poster.md) | `val Poster: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [Title](-title.md) | `val Title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [Type](-type.md) | `val Type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [Year](-year.md) | `val Year: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imdbID](imdb-i-d.md) | `val imdbID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
