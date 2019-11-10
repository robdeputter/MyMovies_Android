package com.example.mymovies

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.models.MovieSerie
import com.example.mymovies.screens.search.MovieSerieAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MovieSerie>?) {
    val adapter = recyclerView.adapter as MovieSerieAdapter
    adapter.submitList(data)
}