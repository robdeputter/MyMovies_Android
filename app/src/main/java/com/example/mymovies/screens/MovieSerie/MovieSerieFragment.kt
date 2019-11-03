package com.example.mymovies.screens.MovieSerie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentMovieSerieBinding

class MovieSerieFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMovieSerieBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_serie, container, false)

        return binding.root;
    }
}