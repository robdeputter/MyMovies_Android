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

/**
 * The [FavoritesFragment] provides the user interface and handles user behaviour for the favorites
 */
class FavoritesFragment : Fragment() {

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
        val binding: FragmentFavoritsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorits, container, false
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

        val viewModelFactory = FavoritesViewModelFactory(application, dataSource)

        /**
         * When the onCreate method is called again (Activity lifecycle), no new instance of [FavoritesViewModel] will be created
         */
        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(FavoritesViewModel::class.java)

        /**
         * Binds the viewModel from the xml to the viewModel that has been created in this fragment
         */
        binding.viewModel = viewModel

        /**
         * [FavoritesAdapter.FavoritesListener]  provides the navigation to the detailed page of the clicked movie or serie
         *
         * [FavoritesAdapter.RemoveListener] provides that the clicked movie or serie is removed from the favorites
         */
        binding.favorites.adapter = FavoritesAdapter(FavoritesAdapter.FavoritesListener {
            viewModel.displayMovieSerieDetails(it)
        },
            FavoritesAdapter.RemoveListener {
                viewModel.removeFromFavorites(it)
            })

        navigateToSelectedMovieSerie(viewModel)

        showEmptyFavoritesInformation(viewModel, binding)

        return binding.root
    }

    /**
     * Displays extra information if the favorites are empty
     */
    private fun showEmptyFavoritesInformation(
        viewModel: FavoritesViewModel,
        binding: FragmentFavoritsBinding
    ) {
        viewModel.favoritesList.observe(this, Observer {
            it?.let {
                if (it.isEmpty()) {
                    binding.statusImage.setImageResource(R.drawable.ic_sad)
                    binding.statusImage.visibility = View.VISIBLE
                    binding.statusText.text = resources.getText(R.string.favorites_empty)
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
     * [FavoritesFragmentDirections] contains all the directions that are created in the navigation xml file (NavGraph)
     */
    private fun navigateToSelectedMovieSerie(viewModel: FavoritesViewModel) {
        viewModel.navigateToSelectedMovieSerie.observe(this, Observer {
            if (it != null) {
                this.findNavController()
                    .navigate(FavoritesFragmentDirections.actionFavoritsFragmentToMovieFragment(it))
                viewModel.displayMovieSerieDetailsComplete()
            }
        })
    }
}