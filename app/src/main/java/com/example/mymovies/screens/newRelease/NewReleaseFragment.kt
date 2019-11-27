package com.example.mymovies.screens.newRelease


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
import com.example.mymovies.databinding.FragmentNewReleasesBinding


class NewReleaseFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentNewReleasesBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_new_releases, container, false)

        binding.setLifecycleOwner(this)


        val application = requireNotNull(this.activity).application

        val dataSource = MyMoviesDatabase.getInstance(application)

        val viewModelFactory = NewReleaseViewModelFactory(application, dataSource)

        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(NewReleaseViewModel::class.java)


        binding.viewModel = viewModel

        binding.newReleases.adapter = NewReleaseAdapter(NewReleaseAdapter.NewReleaseListener {
            viewModel.displayMovieSerieDetails(it)
        })

        viewModel.navigateToSelectedMovieSerie.observe(this, Observer {
            if (it != null) {
                //this.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToMovieFragment(it))
                this.findNavController()
                    .navigate(NewReleaseFragmentDirections.actionNewReleaseFragmentToMovieFragment(it))
                viewModel.displayMovieSerieDetailsComplete()
            }
        })

        return binding.root;
    }


}