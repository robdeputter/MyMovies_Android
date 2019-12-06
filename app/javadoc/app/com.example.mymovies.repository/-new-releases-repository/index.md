[app](../../index.md) / [com.example.mymovies.repository](../index.md) / [NewReleasesRepository](./index.md)

# NewReleasesRepository

`class NewReleasesRepository`

Responsible for getting [NewRelease](../../com.example.mymovies.models/-new-release/index.md) objects

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NewReleasesRepository(_database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md)`)`<br>Responsible for getting [NewRelease](../../com.example.mymovies.models/-new-release/index.md) objects |

### Properties

| Name | Summary |
|---|---|
| [newReleases](new-releases.md) | `val newReleases: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NewRelease`](../../com.example.mymovies.models/-new-release/index.md)`>>`<br>Get all the new releases that are currently in the database |

### Functions

| Name | Summary |
|---|---|
| [refreshNewReleases](refresh-new-releases.md) | `suspend fun refreshNewReleases(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Refresh the database objects by the objects from the network (back-end) |
