[app](../../index.md) / [com.example.mymovies.screens.movieSerie](../index.md) / [MovieSerieViewModel](index.md) / [addToFavorits](./add-to-favorits.md)

# addToFavorits

`fun addToFavorits(rating: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Calls the addFavoriteMethod from the [FavoritsRepository](../../com.example.mymovies.repository/-favorits-repository/index.md)
Is performed asynchronously on the main-thread =&gt; Database operation

Reloads the [MovieSerieDetail](../../com.example.mymovies.models/-movie-serie-detail/index.md) object to renew check if object is in favorites

