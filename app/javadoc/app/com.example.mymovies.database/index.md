[app](../index.md) / [com.example.mymovies.database](./index.md)

## Package com.example.mymovies.database

### Types

| Name | Summary |
|---|---|
| [DatabaseMovieSerieDetail](-database-movie-serie-detail/index.md) | `data class DatabaseMovieSerieDetail`<br>Databaseproperty for the details of a movie or serie |
| [DatabaseNewRelease](-database-new-release/index.md) | `data class DatabaseNewRelease`<br>Databaseproperty for a new release (on Netflix) |
| [FavoritesDAO](-favorites-d-a-o/index.md) | `interface FavoritesDAO`<br>FavoritesDAO is an interface that provides all the methods that are necessary to manipulate the favorites in the database |
| [MyMoviesDatabase](-my-movies-database/index.md) | `abstract class MyMoviesDatabase : RoomDatabase`<br>The database holds your favorites and the latest releases from Netflix |
| [NewReleaseDAO](-new-release-d-a-o/index.md) | `interface NewReleaseDAO`<br>NewReleasesDAO is an interface that provides all the methods that are necessary to manipulate the new releases (on Netflix) in the database |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [asDomainModel](as-domain-model.md) | `fun `[`DatabaseMovieSerieDetail`](-database-movie-serie-detail/index.md)`.asDomainModel(): `[`MovieSerieDetail`](../com.example.mymovies.models/-movie-serie-detail/index.md)<br>Converts a [DatabaseMovieSerieDetail](-database-movie-serie-detail/index.md) to a [MovieSerieDetail](../com.example.mymovies.models/-movie-serie-detail/index.md) |
