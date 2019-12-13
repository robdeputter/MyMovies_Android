package com.example.mymovies.screens.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentDashboardBinding

/**
 * Represents the behavior of the user interface in a [Fragment]
 * The [DashboardFragment] provides the possbility to navigate through the app
 */
class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * Creates an instance of [FragmentDashboardBinding]
         *
         * [FragmentDashboardBinding] => Responsible for binding Dashboard XML files to your model classes
         */
        val binding: FragmentDashboardBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dashboard, container, false
        )

        /**
         * Sets the {@link LifecycleOwner} that should be used for observing changes of
         * LiveData in this binding. If a {@link LiveData} is in one of the binding expressions
         * and no LifecycleOwner is set, the LiveData will not be observed and updates to it
         * will not be propagated to the UI.
         */
        binding.setLifecycleOwner(this)

        onSearchClicked(binding)

        onFavoritesClicked(binding)

        onNewReleasesClicked(binding)

        return binding.root
    }

    /**
     * Navigates to SearchFragment if the searchCardView is clicked
     */
    private fun onSearchClicked(binding: FragmentDashboardBinding) {
        binding.searchCardView.setOnClickListener {
            this.findNavController()
                .navigate(DashboardFragmentDirections.actionDashboardFragmentToSearchFragment())
        }
    }

    /**
     * Navigates to FavoritesFragment if the favoritesCardView is clicked
     */
    private fun onFavoritesClicked(binding: FragmentDashboardBinding) {
        binding.favoritesCardView.setOnClickListener {
            this.findNavController()
                .navigate(DashboardFragmentDirections.actionDashboardFragmentToFavoritsFragment())
        }
    }

    /**
     * Navigates to NewReleasesFragment if the newReleasesCardView is clicked
     */
    private fun onNewReleasesClicked(binding: FragmentDashboardBinding) {
        binding.newReleasesCardView.setOnClickListener {
            this.findNavController()
                .navigate(DashboardFragmentDirections.actionDashboardFragmentToNewReleaseFragment())
        }
    }
}