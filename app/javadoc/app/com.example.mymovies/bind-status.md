[app](../index.md) / [com.example.mymovies](index.md) / [bindStatus](./bind-status.md)

# bindStatus

`fun bindStatus(statusImageView: `[`ImageView`](https://developer.android.com/reference/android/widget/ImageView.html)`, status: `[`MyMoviesApiStatus`](../com.example.mymovies.screens.search/-my-movies-api-status/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

This binding adapter displays the [MyMoviesApiStatus](../com.example.mymovies.screens.search/-my-movies-api-status/index.md) of the network request in an image view.  When
the request is loading, it displays a loading_animation.  If the request has an error, it
displays a broken image to reflect the connection error.  When the request is finished, it
hides the image view. When the status is EMPTY, it shows an appropriate image

