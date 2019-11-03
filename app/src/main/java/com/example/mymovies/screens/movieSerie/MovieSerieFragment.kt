package com.example.mymovies.screens.movieSerie

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }


}