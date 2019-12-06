[app](../../index.md) / [com.example.mymovies.screens.newRelease](../index.md) / [NewReleaseViewModelFactory](./index.md)

# NewReleaseViewModelFactory

`class NewReleaseViewModelFactory : Factory`

Responsible for creating a [NewReleaseViewModel](../-new-release-view-model/index.md) instance

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NewReleaseViewModelFactory(application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`, database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md)`)`<br>Responsible for creating a [NewReleaseViewModel](../-new-release-view-model/index.md) instance |

### Properties

| Name | Summary |
|---|---|
| [application](application.md) | `val application: `[`Application`](https://developer.android.com/reference/android/app/Application.html) |
| [database](database.md) | `val database: `[`MyMoviesDatabase`](../../com.example.mymovies.database/-my-movies-database/index.md) |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T : ViewModel?> create(modelClass: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<`[`T`](create.md#T)`>): `[`T`](create.md#T) |
