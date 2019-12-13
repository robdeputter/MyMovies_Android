package com.example.mymovies.screens.watchlist

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
import com.example.mymovies.databinding.FragmentWatchlistBinding

/**
 * The [FavoritesFragment] provides the user interface and handles user behaviour for the favorites
 */
class WatchlistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * Creates an instance of [FragmentFavoritsBinding]
         *
         * [FragmentFavoritsBinding] => Responsible for binding Favorites XML files to your model classes
         */
        val binding: FragmentWatchlistBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_watchlist, container, false
        )

        /**
         * Sets the {@link LifecycleOwner} that should be used for observing changes of
         * LiveData in this binding. If a {@link LiveData} is in one of the binding expressions
         * and no LifecycleOwner is set, the LiveData will not be observed and updates to it
         * will not be propagated to the UI.
         */
        binding.setLifecycleOwner(this)

        val application = requireNotNull(this.activity).application

        val dataSource = MyMoviesDatabase.getInstance(application)

        val viewModelFactory = WatchlistViewModelFactory(application, dataSource)

        /**
         * When the onCreate method is called again (Activity lifecycle), no new instance of [WatchlistViewModel] will be created
         */
        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(WatchlistViewModel::class.java)

        /**
         * Binds the viewModel from the xml to the viewModel that has been created in this fragment
         */
        binding.viewModel = viewModel

        /**
         * [WatchlistAdapter.WatchlistListener]  provides the navigation to the detailed page of the clicked movie or serie
         *
         * [WatchlistAdapter.RemoveListener] provides that the clicked movie or serie is removed from the watchlist
         */
        binding.watchlist.adapter = WatchlistAdapter(WatchlistAdapter.WatchlistListener {
            viewModel.displayMovieSerieDetails(it)
        },
            WatchlistAdapter.RemoveListener {
                viewModel.removeFromFavorites(it)
            })

        navigateToSelectedMovieSerie(viewModel)

        showEmptywatchListInformation(viewModel, binding)

        return binding.root
    }

    /**
     * Displays extra information if the favorites are empty
     */
    private fun showEmptywatchListInformation(
        viewModel: WatchlistViewModel,
        binding: FragmentWatchlistBinding
    ) {
        viewModel.watchlistEntities.observe(this, Observer {
            it?.let {
                if (it.isEmpty()) {
                    binding.statusImage.setImageResource(R.drawable.ic_sad)
                    binding.statusImage.visibility = View.VISIBLE
                    binding.statusText.text = resources.getText(R.string.watchlist_empty)
                } else {
                    binding.statusImage.visibility = View.GONE
                    binding.statusText.text = ""
                }
            }
        })
    }

    /**
     * Provides the navigation to the detailed page of movie or serie
     * it = imdbId
     * [WatchlistFragmentDirections] contains all the directions that are created in the navigation xml file (NavGraph)
     */
    private fun navigateToSelectedMovieSerie(viewModel: WatchlistViewModel) {
        viewModel.navigateToSelectedMovieSerie.observe(this, Observer {
            if (it != null) {
                this.findNavController()
                    .navigate(WatchlistFragmentDirections.actionWatchlistFragmentToMovieFragment(it))
                viewModel.displayMovieSerieDetailsComplete()
            }
        })
    }
}