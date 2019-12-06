[app](../index.md) / [com.example.mymovies.models](./index.md)

## Package com.example.mymovies.models

### Types

| Name | Summary |
|---|---|
| [MovieSerie](-movie-serie/index.md) | `data class MovieSerie`<br>MovieSerie is a short list of details that describe a movie or serie |
| [MovieSerieDetail](-movie-serie-detail/index.md) | `data class MovieSerieDetail`<br>MovieSerieDetail is detailed list that describes a movie or serie |
| [MovieSerieResponse](-movie-serie-response/index.md) | `data class MovieSerieResponse`<br>MovieSerieResponse corresponds to the data that you get from imdb-network |
| [NewRelease](-new-release/index.md) | `data class NewRelease`<br>NewRelease is a list of details that describe of new release (on Netflix) |
| [NewReleaseResponse](-new-release-response/index.md) | `data class NewReleaseResponse`<br>NewReleaseResponse corresponds to the data that you get from the uNoGS-network (uNoGS = unofficial Netflix online Global Search) |

### Functions

| Name | Summary |
|---|---|
| [asDatabaseModel](as-database-model.md) | `fun `[`MovieSerieDetail`](-movie-serie-detail/index.md)`.asDatabaseModel(): `[`DatabaseMovieSerieDetail`](../com.example.mymovies.database/-database-movie-serie-detail/index.md)<br>Converts a MovieSerieDetail to a databaseproperty This method is called when you want to add a favorite to the database |
