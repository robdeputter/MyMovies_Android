package com.example.mymovies.screens.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.mymovies.R
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.databinding.FragmentFavoritsBinding


class FavoritesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFavoritsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorits, container, false
        )

        binding.setLifecycleOwner(this)

        val application = requireNotNull(this.activity).application

        val dataSource = MyMoviesDatabase.getInstance(application)

        val viewModelFactory = FavoritesViewModelFactory(application, dataSource)

        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(FavoritesViewModel::class.java)


        binding.viewModel = viewModel

        binding.favorites.adapter = FavoritesAdapter(FavoritesAdapter.FavoritesListener {
            viewModel.displayMovieSerieDetails(it)
        })

        navigateToSelectedMovieSerie(viewModel)

        return binding.root;
    }



    private fun navigateToSelectedMovieSerie(viewModel : FavoritesViewModel){
        viewModel.navigateToSelectedMovieSerie.observe(this, Observer {
            if (it != null) {
                //this.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToMovieFragment(it))
                this.findNavController()
                    .navigate(FavoritesFragmentDirections.actionFavoritsFragmentToMovieFragment(it))
                viewModel.displayMovieSerieDetailsComplete()
            }
        })
    }


}