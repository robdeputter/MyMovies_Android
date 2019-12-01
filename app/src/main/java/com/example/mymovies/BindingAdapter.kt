package com.example.mymovies

import android.view.View
import android.widget.ImageView
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

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MovieSerie>?) {
    val adapter = recyclerView.adapter as MovieSerieAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataFavorits")
fun bindRecyclerViewFavorits(recyclerView: RecyclerView, data: List<MovieSerieDetail>?) {
    val adapter = recyclerView.adapter as FavoritesAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataNewReleases")
fun bindRecyclerViewNewReleases(recyclerView: RecyclerView, data: List<NewRelease>?) {
    val adapter = recyclerView.adapter as NewReleaseAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

/**
 * This binding adapter displays the [MarsApiStatus] of the network request in an image view.  When
 * the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
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