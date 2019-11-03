package com.example.mymovies.screens.watchList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentWatchListBinding

class WatchListFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentWatchListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_watch_list, container, false)

        return binding.root;

    }
}