[app](../../index.md) / [com.example.mymovies.screens.movieSerie](../index.md) / [MovieSerieViewModel](index.md) / [addToWatchlist](./add-to-watchlist.md)

# addToWatchlist

`fun addToWatchlist(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Calls the addFavoriteMethod from the [WatchListRepository](../../com.example.mymovies.repository/-watch-list-repository/index.md)
Is performed asynchronously on the main-thread =&gt; Database operation

Reloads the [MovieSerieDetail](../../com.example.mymovies.models/-movie-serie-detail/index.md) object to renew check if object is in watchlist

