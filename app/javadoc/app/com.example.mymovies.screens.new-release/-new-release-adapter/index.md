[app](../../index.md) / [com.example.mymovies.screens.newRelease](../index.md) / [NewReleaseAdapter](./index.md)

# NewReleaseAdapter

`class NewReleaseAdapter : ListAdapter<`[`NewRelease`](../../com.example.mymovies.models/-new-release/index.md)`, `[`ViewHolder`](-view-holder/index.md)`>`

Responsible for binding each item of the [RecyclerView](#) that represents the new releases

### Types

| Name | Summary |
|---|---|
| [DiffCallback](-diff-callback/index.md) | `companion object DiffCallback : ItemCallback<`[`NewRelease`](../../com.example.mymovies.models/-new-release/index.md)`>`<br>Checks if there are different items |
| [NewReleaseListener](-new-release-listener/index.md) | `class NewReleaseListener`<br>If an item was clicked, the NewReleaseListener sends the imdbId of that item |
| [ViewHolder](-view-holder/index.md) | `class ViewHolder : ViewHolder`<br>Describes an item view and metadata about its place within the RecyclerView. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NewReleaseAdapter(clickListener: `[`NewReleaseListener`](-new-release-listener/index.md)`)`<br>Responsible for binding each item of the [RecyclerView](#) that represents the new releases |

### Properties

| Name | Summary |
|---|---|
| [clickListener](click-listener.md) | `val clickListener: `[`NewReleaseListener`](-new-release-listener/index.md) |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Binds each item |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewHolder`](-view-holder/index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`NewRelease`](../../com.example.mymovies.models/-new-release/index.md)`, newItem: `[`NewRelease`](../../com.example.mymovies.models/-new-release/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`NewRelease`](../../com.example.mymovies.models/-new-release/index.md)`, newItem: `[`NewRelease`](../../com.example.mymovies.models/-new-release/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
