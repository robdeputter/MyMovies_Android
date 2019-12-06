[app](../../index.md) / [com.example.mymovies.screens.search](../index.md) / [SearchFragment](./index.md)

# SearchFragment

`class SearchFragment : Fragment, CoroutineScope`

The [SearchFragment](./index.md) provides the user interface and handles user behaviour for searching to movies and series

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SearchFragment()`<br>The [SearchFragment](./index.md) provides the user interface and handles user behaviour for searching to movies and series |

### Properties

| Name | Summary |
|---|---|
| [coroutineContext](coroutine-context.md) | `val coroutineContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onSaveInstanceState](on-save-instance-state.md) | `fun onSaveInstanceState(outState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves the current state of the page. If a dialog is opened, it will save "true" in outState |
| [onViewStateRestored](on-view-state-restored.md) | `fun onViewStateRestored(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Makes it possible to rotate the screen and not losing the dialogview |
