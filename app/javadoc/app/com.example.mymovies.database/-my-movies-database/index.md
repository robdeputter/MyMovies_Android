[app](../../index.md) / [com.example.mymovies.database](../index.md) / [MyMoviesDatabase](./index.md)

# MyMoviesDatabase

`abstract class MyMoviesDatabase : RoomDatabase`

The database holds your favorites and the latest releases from Netflix

[Database](#) = The list of entities included in the database. Each entity turns into a table in the database.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MyMoviesDatabase()`<br>The database holds your favorites and the latest releases from Netflix |

### Properties

| Name | Summary |
|---|---|
| [favoritesDAO](favorites-d-a-o.md) | `abstract val favoritesDAO: `[`FavoritesDAO`](../-favorites-d-a-o/index.md) |
| [newReleasesDAO](new-releases-d-a-o.md) | `abstract val newReleasesDAO: `[`NewReleaseDAO`](../-new-release-d-a-o/index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | `fun getInstance(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`MyMoviesDatabase`](./index.md) |
