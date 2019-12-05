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

class DashboardFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentDashboardBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dashboard, container, false
        )

        binding.setLifecycleOwner(this)

        onSearchClicked(binding)

        onFavoritesClicked(binding)

        onNewReleasesClicked(binding)

        return binding.root
    }

    private fun onSearchClicked(binding: FragmentDashboardBinding){
        binding.searchCardView.setOnClickListener {
            this.findNavController()
                .navigate(DashboardFragmentDirections.actionDashboardFragmentToSearchFragment())
        }
    }

    private fun onFavoritesClicked(binding: FragmentDashboardBinding){
        binding.favoritesCardView.setOnClickListener {
            this.findNavController()
                .navigate(DashboardFragmentDirections.actionDashboardFragmentToFavoritsFragment())
        }
    }

    private fun onNewReleasesClicked(binding: FragmentDashboardBinding){
        binding.newReleasesCardView.setOnClickListener {
            this.findNavController()
                .navigate(DashboardFragmentDirections.actionDashboardFragmentToNewReleaseFragment())
        }
    }
}