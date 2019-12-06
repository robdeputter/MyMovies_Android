[app](../../index.md) / [com.example.mymovies.screens.favorites](../index.md) / [FavoritesAdapter](./index.md)

# FavoritesAdapter

`class FavoritesAdapter : ListAdapter<`[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`, `[`ViewHolder`](-view-holder/index.md)`>`

Responsible for binding each item of the [RecyclerView](#) that represents the favorites

### Types

| Name | Summary |
|---|---|
| [DiffCallback](-diff-callback/index.md) | `companion object DiffCallback : ItemCallback<`[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`>`<br>Checks if there are different items |
| [FavoritesListener](-favorites-listener/index.md) | `class FavoritesListener`<br>If an item was clicked, the FavoritesListener sends the imdbId of that item |
| [RemoveListener](-remove-listener/index.md) | `class RemoveListener`<br>If an item is clicked, the RemoveListener sends the [MovieSerieDetail](../../com.example.mymovies.models/-movie-serie-detail/index.md) object of that item |
| [ViewHolder](-view-holder/index.md) | `class ViewHolder : ViewHolder`<br>Describes an item view and metadata about its place within the RecyclerView. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FavoritesAdapter(clickListener: `[`FavoritesListener`](-favorites-listener/index.md)`, removedListener: `[`RemoveListener`](-remove-listener/index.md)`)`<br>Responsible for binding each item of the [RecyclerView](#) that represents the favorites |

### Properties

| Name | Summary |
|---|---|
| [clickListener](click-listener.md) | `val clickListener: `[`FavoritesListener`](-favorites-listener/index.md) |
| [removedListener](removed-listener.md) | `val removedListener: `[`RemoveListener`](-remove-listener/index.md) |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds each item |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewHolder`](-view-holder/index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`, newItem: `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`, newItem: `[`MovieSerieDetail`](../../com.example.mymovies.models/-movie-serie-detail/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
