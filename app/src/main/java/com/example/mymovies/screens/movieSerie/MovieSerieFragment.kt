package com.example.mymovies.screens.movieSerie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.mymovies.R
import com.example.mymovies.database.MovieSerieDatabase
import com.example.mymovies.databinding.FragmentMovieSerieBinding

public class MovieSerieFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMovieSerieBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_serie, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = MovieSerieDatabase.getInstance(application).movieSerieDAO

        val arguments = MovieSerieFragmentArgs.fromBundle(arguments!!) // I need to get the imdbId from arguments!!!!!
        val viewModelFactory = MovieSerieViewModelFactory(dataSource,application,arguments.imdbId)

        val viewModel = ViewModelProviders.of(this,viewModelFactory).get(MovieSerieViewModel::class.java)


        binding.setLifecycleOwner(this);

        binding.viewModel = viewModel

        return binding.root;
    }


}