package com.example.mymovies

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mymovies.models.MovieSerie
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.NewRelease
import com.example.mymovies.screens.favorites.FavoritesAdapter
import com.example.mymovies.screens.newRelease.NewReleaseAdapter
import com.example.mymovies.screens.search.MovieSerieAdapter
import com.example.mymovies.screens.search.MyMoviesApiStatus
import com.example.mymovies.screens.watchlist.WatchlistAdapter

/**
 * Submits list of [MovieSerie] to [MovieSerieAdapter]
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MovieSerie>?) {
    val adapter = recyclerView.adapter as MovieSerieAdapter
    adapter.submitList(data)
}

/**
 * Submits list of [MovieSerieDetail] to [FavoritesAdapter]
 */
@BindingAdapter("listDataFavorits")
fun bindRecyclerViewFavorits(recyclerView: RecyclerView, data: List<MovieSerieDetail>?) {
    val adapter = recyclerView.adapter as FavoritesAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataWatchlist")
fun bindRecyclerViewWatchlist(recyclerView: RecyclerView, data: List<MovieSerieDetail>?) {
    val adapter = recyclerView.adapter as WatchlistAdapter
    adapter.submitList(data)
}

/**
 * Submits list of [NewRelease] to [NewReleaseAdapter]
 */
@BindingAdapter("listDataNewReleases")
fun bindRecyclerViewNewReleases(recyclerView: RecyclerView, data: List<NewRelease>?) {
    val adapter = recyclerView.adapter as NewReleaseAdapter
    adapter.submitList(data)
}

/**
 * Downloads imageUri with [Glide]
 * Glide will set the imageUri in the imageView
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

/**
 * This binding adapter displays the [MyMoviesApiStatus] of the network request in an image view.  When
 * the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view. When the status is EMPTY, it shows an appropriate image
 */
@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: MyMoviesApiStatus?) {
    when (status) {
        MyMoviesApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MyMoviesApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MyMoviesApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }

        MyMoviesApiStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_empty)
        }
    }
}

/**
 * When [MyMoviesApiStatus] shows that the request is done, then it makes the textView VISIBLE,
 * in all other cases, it's GONE
 */
@BindingAdapter("headerText")
fun bindCastText(textView: TextView, status: MyMoviesApiStatus?) {
    when (status) {
        MyMoviesApiStatus.LOADING -> {
            textView.visibility = View.GONE
        }
        MyMoviesApiStatus.ERROR -> {
            textView.visibility = View.GONE
        }
        MyMoviesApiStatus.DONE -> {
            textView.visibility = View.VISIBLE
        }
        MyMoviesApiStatus.EMPTY -> {
            textView.visibility = View.GONE
        }
    }
}

@BindingAdapter("imdbRating")
fun bindImdbRating(textView: TextView, rating: String?) {
    var resultString = rating + "/10"
    textView.text = resultString
}

@BindingAdapter("imdbVotes")
fun bindImdbVotes(textView: TextView, votes: String?) {
    var resultString = " (based on " + votes + " votes)"
    textView.text = resultString
}

@BindingAdapter("released")
fun bindReleased(textView: TextView, released: String?) {
    var resultString = "Released: " + released
    textView.text = resultString
}

@BindingAdapter("genre")
fun bindGenres(textView: TextView, genre: String?) {
    var resultString = "Genre(s): " + genre
    textView.text = resultString
}