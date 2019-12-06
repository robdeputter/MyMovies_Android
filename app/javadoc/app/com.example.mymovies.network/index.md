[app](../index.md) / [com.example.mymovies.network](./index.md)

## Package com.example.mymovies.network

### Types

| Name | Summary |
|---|---|
| [MyMoviesApi](-my-movies-api/index.md) | `object MyMoviesApi`<br>[object](#) =&gt; singleton Provides a lazy initialization of [MyMoviesApiService](-my-movies-api-service/index.md) lazy =&gt; you create it when it's needed |
| [MyMoviesApiService](-my-movies-api-service/index.md) | `interface MyMoviesApiService`<br>Contains all the network calls to get [MovieSerieDetail](../com.example.mymovies.models/-movie-serie-detail/index.md) and [MovieSerie](../com.example.mymovies.models/-movie-serie/index.md) properties |
| [NetworkMovieSerie](-network-movie-serie/index.md) | `data class NetworkMovieSerie`<br>The network version of [MovieSerie](../com.example.mymovies.models/-movie-serie/index.md) Jsondata that's received from the imdb-network is parsed in this data class |
| [NetworkMovieSerieDetail](-network-movie-serie-detail/index.md) | `data class NetworkMovieSerieDetail`<br>The network version of [MovieSerieDetail](../com.example.mymovies.models/-movie-serie-detail/index.md) |
| [NetworkNewRelease](-network-new-release/index.md) | `data class NetworkNewRelease`<br>The network version of [NewRelease](../com.example.mymovies.models/-new-release/index.md) |
| [NewReleasesApi](-new-releases-api/index.md) | `object NewReleasesApi`<br>[object](#) =&gt; singleton Provides a lazy initialization of [NewReleasesApiService](-new-releases-api-service/index.md) lazy =&gt; you create it when it's needed |
| [NewReleasesApiService](-new-releases-api-service/index.md) | `interface NewReleasesApiService` |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [asDatabaseModel](as-database-model.md) | `fun `[`NetworkMovieSerieDetail`](-network-movie-serie-detail/index.md)`.asDatabaseModel(): `[`DatabaseMovieSerieDetail`](../com.example.mymovies.database/-database-movie-serie-detail/index.md)<br>Converts a list of [NetworkMovieSerieDetail](-network-movie-serie-detail/index.md) to a list of [DatabaseMovieSerieDetail](../com.example.mymovies.database/-database-movie-serie-detail/index.md) |
| [asDomainModel](as-domain-model.md) | `fun `[`NetworkMovieSerieDetail`](-network-movie-serie-detail/index.md)`.asDomainModel(): `[`MovieSerieDetail`](../com.example.mymovies.models/-movie-serie-detail/index.md)<br>Converts a list of [NetworkMovieSerieDetail](-network-movie-serie-detail/index.md) to a list of [NetworkMovieSerie](-network-movie-serie/index.md) |
