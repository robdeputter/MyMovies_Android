package com.example.mymovies.screens.favorits

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
import com.example.mymovies.database.FavoritsDatabase
import com.example.mymovies.databinding.FragmentFavoritsBinding
import com.example.mymovies.screens.search.SearchFragmentDirections


class FavoritsFragment : Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFavoritsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorits, container, false)

        binding.setLifecycleOwner(this)


        val application = requireNotNull(this.activity).application

        val dataSource = FavoritsDatabase.getInstance(application)

        val viewModelFactory = FavoritsViewModelFactory(application,dataSource)

        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(FavoritsViewModel::class.java)


        binding.viewModel = viewModel

        binding.favorits.adapter = FavoritsAdapter(FavoritsAdapter.FavoritsListener {
            viewModel.displayMovieSerieDetails(it)
        })

        viewModel.navigateToSelectedMovieSerie.observe(this, Observer {
            if (it != null){
                //this.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToMovieFragment(it))
                this.findNavController().navigate(FavoritsFragmentDirections.actionFavoritsFragmentToMovieFragment(it))
                viewModel.displayMovieSerieDetailsComplete()
            }
        })



        return binding.root;

    }


}