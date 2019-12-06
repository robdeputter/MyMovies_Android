[app](../../index.md) / [com.example.mymovies.database](../index.md) / [NewReleaseDAO](./index.md)

# NewReleaseDAO

`interface NewReleaseDAO`

NewReleasesDAO is an interface that provides all the methods that are necessary to manipulate the new releases (on Netflix)
in the database

[Dao](#) Data Access Objects are the main classes where you define your database interactions. $
They can include a variety of query methods.

### Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | `abstract fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clear the new releases |
| [delete](delete.md) | `abstract fun delete(newRelease: `[`DatabaseNewRelease`](../-database-new-release/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Delete an object of a new release to the database. |
| [get](get.md) | `abstract fun get(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`DatabaseNewRelease`](../-database-new-release/index.md)`?`<br>Get a new release by it's imdbId |
| [getAllNewReleases](get-all-new-releases.md) | `abstract fun getAllNewReleases(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`DatabaseNewRelease`](../-database-new-release/index.md)`>>`<br>Get all the new releases |
| [insert](insert.md) | `abstract fun insert(newRelease: `[`DatabaseNewRelease`](../-database-new-release/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Add an object of a new release to the database. |
| [insertAll](insert-all.md) | `abstract fun insertAll(vararg newReleases: `[`DatabaseNewRelease`](../-database-new-release/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Insert all the new releases |
| [update](update.md) | `abstract fun update(newRelease: `[`DatabaseNewRelease`](../-database-new-release/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Update an object of a new release to the database. |
