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

/**
 * The [NewReleaseFragment] provides the user interface and handles user behaviour for the new releases from Netflix
 */
class NewReleaseFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /**
         * Creates an instance of [FragmentNewReleasesBinding]
         *
         * [FragmentNewReleasesBinding] => Responsible for binding Favorites XML files to your model classes
         */
        val binding: FragmentNewReleasesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_new_releases, container, false)


        /**
         * Sets the {@link LifecycleOwner} that should be used for observing changes of
         * LiveData in this binding. If a {@link LiveData} is in one of the binding expressions
         * and no LifecycleOwner is set, the LiveData will not be observed and updates to it
         * will not be propagated to the UI.
         */
        binding.setLifecycleOwner(this)


        val application = requireNotNull(this.activity).application

        val dataSource = MyMoviesDatabase.getInstance(application)

        val viewModelFactory = NewReleaseViewModelFactory(application, dataSource)

        /**
         * When the onCreate method is called again (Activity lifecycle), no new instance of [NewReleaseViewModel] will be created
         */
        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(NewReleaseViewModel::class.java)


        /**
         * Binds the viewModel from the xml to the viewModel that has been created in this fragment
         */
        binding.viewModel = viewModel

        /**
         * [NewReleaseAdapter.NewReleaseListener]  provides the navigation to the detailed page of the clicked new release
         */
        binding.newReleases.adapter = NewReleaseAdapter(NewReleaseAdapter.NewReleaseListener {
            viewModel.displayMovieSerieDetails(it)
        })

        navigateToSelectedMovie(viewModel)

        return binding.root;
    }

    /**
     * Provides the navigation to the detailed page of movie or serie
     * it = imdbId
     * [NewReleaseFragmentDirections] contains all the directions that are created in the navigation xml file (NavGraph)
     */
    private fun navigateToSelectedMovie(viewModel: NewReleaseViewModel) {
        viewModel.navigateToSelectedMovieSerie.observe(this, Observer {
            if (it != null) {
                this.findNavController()
                    .navigate(
                        NewReleaseFragmentDirections.actionNewReleaseFragmentToMovieFragment(
                            it
                        )
                    )
                viewModel.displayMovieSerieDetailsComplete()
            }
        })
    }
}